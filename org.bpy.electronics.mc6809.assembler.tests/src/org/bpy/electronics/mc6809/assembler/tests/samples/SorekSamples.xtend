/*
 * MC6809 Toolkit
 * Copyright (C) 2023  Patrick BRIAND
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.bpy.electronics.mc6809.assembler.tests.samples

import org.junit.runner.RunWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.InjectWith
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider
import com.google.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import org.bpy.electronics.mc6809.assembler.assembler.Model
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Assert
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine
import org.junit.Test
import org.bpy.electronics.mc6809.assembler.assembler.AbxInstruction

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class SorekSamples {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * 
	 */
	@Test 
	def void testSample173() {
		val result = parseHelper.parse('''
		;******************************************************
		; réception de donnée avec ligne série
		; vérifications diverses (format, parité, surcharge)
		; contrôle du transmetteur par ligne RTS
		;******************************************************
					ORG 		$8000 				;
		;------adresses des registres du 6850
		RCRIMP 		EQU 		$EC00 				; reg. contrôle
		RSRIMP 		EQU 		$EC00 				; reg. Etat
		RRXIMP 		EQU 		$EC01 				; reg. Réception
					LDB 		#%01000011 			; initialisation programmée avec
													; RTS=1 (ligne RTS à -12v)
					STB 		RCRIMP 				; registre contrôle
					LDX 		#$8100 				; adrs rangement données
					LDY 		#10 				; nb d'octet à recevoir
					LEAY 		-1,Y 				; écarter dernière donnée
													;
		;------Configurer le mode de réception et actionner ligne RTS
					LDB 		#%00000001 			; 7 Bits,parité paire,2 stop, clock 1/16
													; + RTS |=0 (ligne RTS= +12v)
					STB 		RCRIMP 				;
													;
		;------Réception données avec vérifications diverses
		ATDON 		LDB 		RSRIMP 				; reg. Etat
					BITB 		#%00000001 			; Examen bit réception
					BNE 		VERIF 				; SR0=1, alors vérification
					BITB 		#%00000100 			; examen bit DCD
					BEQ 		ATDON 				; SR2=0, alors ATtente DONnée
					BRA 		TMDCD 				; --> TraiteMent DCD
		;------Vérification format, parité, surcharge
		VERIF 		BITB 		#%01110000 			; test global
					BEQ 		RXDON 				; sans erreur, --> Rx réception donnée
					BITB 		#%00010000 			; erreur format ?
					BEQ 		*+4 				; sinon test suivant adrs +4
					BRA 		ERFMT 				; --> erreur format
					BITB 		#%01000000 			; erreur parité ?
					BEQ 		*+4 				; sinon --> erreur surcharge
					BRA 		ERPAR 				; --> erreur PARité
					BRA 		ERSCH 				; --> erreur SurCHarge
													;
		;------Aucune erreur détectée, lecture donnée
		RXDON 		LDA 		RRXIMP 				; lecture reg. réception
					STA 		,X+ 				; rangement donnée épuisé ?
					LEAY 		-1,Y 				; Nb données épuisé ?
					BNE 		ATDON 				;
													;
		;------Inhibition de l'émetteur
					LDB 		#%01000001 			; RTS |=1 (ligne RTS à -12v)
					STB 		RCRIMP 				; reg. contrôle
													;
		;------Lecture derniére donnée en cours
					LDB 		RSRIMP 				; reg. Etat
					RORB 							;
					BCC 		*-4 				;
					LDA 		RRXIMP 				;
					STA 		,X+ 				; rangement
					SWI 							;
					;
		;------Si une ou plusieurs erreurs sont présentes,
		;------elles sont indiquées dans le registre B
		ERFMT 		SWI 							;
		ERPAR 		SWI 							;
		ERSCH 		SWI 							;
		TMDCD 		SWI 							;
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
	}

	@Test
	def void checkProg1_A() {
		val result = parseHelper.parse('''
					ORG 		$0000 				; Début du programme
					LDX 		#$0100 				; Début de table
					LDA 		#$00 				; 1ere données $00
		Boucle 		STA 		,X+ 				; Chargement et incrémentation du pointeur
					CMPA 		#$FF 				; Dernière donnée = $FF alors fin de programme
					BEQ 		Fin 				;
					INCA 							; Incrémentation de la donnée
					BRA 		Boucle 				;
		Fin 		SWI 							;
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
	}
	@Test

	def void checkProg1_B() {
		val result = parseHelper.parse('''
					ORG 		$0000 			; Début du programme
					LDX 		#$0200 			; Début 1ere donnée négative
					LDY 		#$0280 			; Début 1ere donnée positive
					LDA 		#$FF 			; 1ere donnée négative $FF
		BOUCLE 		STA 		,X+ 			; Chargement et incrémentation du pointeur X
					CMPA 		#$80 			; Si donnée = $80 fin des données négatives
					BEQ 		POSITIF 		;
					DECA 						; Décrémentation de la donnée
					BRA 		BOUCLE 			;
					LDA 		#$00 			; 1ere donnée positive
		BOUCLE1 	STA 		,Y+ 			; Chargement et incrémentation du pointeur
					CMPA 		#$7F 			; Si donnée = $7F fin des données positives
					BEQ 		FIN 			;
					INCA 						; Incrémentation de la donnée
					BRA 		BOUCLE1 		;
		FIN 		SWI 						;
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
	} 

/* 
	def void empty() {
		val result = parseHelper.parse('''
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
	} 
*/
}