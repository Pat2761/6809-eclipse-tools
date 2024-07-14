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
package org.bpy.electronics.mc6809.assembler.tests.samples;

import org.junit.runner.RunWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.InjectWith;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
import com.google.inject.Inject;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Test;

@RunWith(XtextRunner.class)
@InjectWith(AssemblerInjectorProvider.class)

public class SorekSamples {
	@Inject ParseHelper<Model> parseHelper;
	@Inject @Extension private ValidationTestHelper validationHelper;
	
	/**
	 * 
	 */
	@Test 
	public void testSample173() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(";******************************************************\n");
		strBuilder.append("; réception de donnée avec ligne série\n");
		strBuilder.append("; vérifications diverses (format, parité, surcharge)\n");
		strBuilder.append("; contrôle du transmetteur par ligne RTS\n");
		strBuilder.append(";******************************************************\n");
		strBuilder.append("			ORG 		$8000 				;\n");
		strBuilder.append(";------adresses des registres du 6850\n");
		strBuilder.append("RCRIMP 		EQU 		$EC00 				; reg. contrôle\n");
		strBuilder.append("RSRIMP 		EQU 		$EC00 				; reg. Etat\n");
		strBuilder.append("RRXIMP 		EQU 		$EC01 				; reg. Réception\n");
		strBuilder.append("			LDB 		#%01000011 			; initialisation programmée avec\n");
		strBuilder.append("											; RTS=1 (ligne RTS à -12v)\n");
		strBuilder.append("			STB 		RCRIMP 				; registre contrôle\n");
		strBuilder.append("			LDX 		#$8100 				; adrs rangement données\n");
		strBuilder.append("			LDY 		#10 				; nb d'octet à recevoir\n");
		strBuilder.append("			LEAY 		-1,Y 				; écarter dernière donnée\n");
		strBuilder.append("											;\n");
		strBuilder.append(";------Configurer le mode de réception et actionner ligne RTS\n");
		strBuilder.append("			LDB 		#%00000001 			; 7 Bits,parité paire,2 stop, clock 1/16\n");
		strBuilder.append("											; + RTS |=0 (ligne RTS= +12v)\n");
		strBuilder.append("			STB 		RCRIMP 				;\n");
		strBuilder.append("											;\n");
		strBuilder.append(";------Réception données avec vérifications diverses\n");
		strBuilder.append("ATDON 		LDB 		RSRIMP 				; reg. Etat\n");
		strBuilder.append("			BITB 		#%00000001 			; Examen bit réception\n");
		strBuilder.append("			BNE 		VERIF 				; SR0=1, alors vérification\n");
		strBuilder.append("			BITB 		#%00000100 			; examen bit DCD\n");
		strBuilder.append("			BEQ 		ATDON 				; SR2=0, alors ATtente DONnée\n");
		strBuilder.append("			BRA 		TMDCD 				; --> TraiteMent DCD\n");
		strBuilder.append(";------Vérification format, parité, surcharge\n");
		strBuilder.append("VERIF 		BITB 		#%01110000 			; test global\n");
		strBuilder.append("			BEQ 		RXDON 				; sans erreur, --> Rx réception donnée\n");
		strBuilder.append("			BITB 		#%00010000 			; erreur format ?\n");
		strBuilder.append("			BEQ 		*+4 				; sinon test suivant adrs +4\n");
		strBuilder.append("			BRA 		ERFMT 				; --> erreur format\n");
		strBuilder.append("			BITB 		#%01000000 			; erreur parité ?\n");
		strBuilder.append("			BEQ 		*+4 				; sinon --> erreur surcharge\n");
		strBuilder.append("			BRA 		ERPAR 				; --> erreur PARité\n");
		strBuilder.append("			BRA 		ERSCH 				; --> erreur SurCHarge\n");
		strBuilder.append("											;\n");
		strBuilder.append(";------Aucune erreur détectée, lecture donnée\n");
		strBuilder.append("RXDON 		LDA 		RRXIMP 				; lecture reg. réception\n");
		strBuilder.append("			STA 		,X+ 				; rangement donnée épuisé ?\n");
		strBuilder.append("			LEAY 		-1,Y 				; Nb données épuisé ?\n");
		strBuilder.append("			BNE 		ATDON 				;\n");
		strBuilder.append("											;\n");
		strBuilder.append(";------Inhibition de l'émetteur\n");
		strBuilder.append("			LDB 		#%01000001 			; RTS |=1 (ligne RTS à -12v)\n");
		strBuilder.append("			STB 		RCRIMP 				; reg. contrôle\n");
		strBuilder.append("											;\n");
		strBuilder.append(";------Lecture derniére donnée en cours\n");
		strBuilder.append("			LDB 		RSRIMP 				; reg. Etat\n");
		strBuilder.append("			RORB 							;\n");
		strBuilder.append("			BCC 		*-4 				;\n");
		strBuilder.append("			LDA 		RRXIMP 				;\n");
		strBuilder.append("			STA 		,X+ 				; rangement\n");
		strBuilder.append("			SWI 							;\n");
		strBuilder.append("			;\n");
		strBuilder.append(";------Si une ou plusieurs erreurs sont présentes,\n");
		strBuilder.append(";------elles sont indiquées dans le registre B\n");
		strBuilder.append("ERFMT 		SWI 							;\n");
		strBuilder.append("ERPAR 		SWI 							;\n");
		strBuilder.append("ERSCH 		SWI 							;\n");
		strBuilder.append("TMDCD 		SWI 							;\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	@Test
	public void checkProg1_A() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("			ORG 		$0000 				; Début du programme\n");
		strBuilder.append("			LDX 		#$0100 				; Début de table\n");
		strBuilder.append("			LDA 		#$00 				; 1ere données $00\n");
		strBuilder.append("Boucle 		STA 		,X+ 				; Chargement et incrémentation du pointeur\n");
		strBuilder.append("			CMPA 		#$FF 				; Dernière donnée = $FF alors fin de programme\n");
		strBuilder.append("			BEQ 		Fin 				;\n");
		strBuilder.append("			INCA 							; Incrémentation de la donnée\n");
		strBuilder.append("			BRA 		Boucle 				;\n");
		strBuilder.append("Fin 		SWI 							;\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	@Test

	public void checkProg1_B() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("			ORG 		$0000 			; Début du programme\n");
		strBuilder.append("			LDX 		#$0200 			; Début 1ere donnée négative\n");
		strBuilder.append("			LDY 		#$0280 			; Début 1ere donnée positive\n");
		strBuilder.append("			LDA 		#$FF 			; 1ere donnée négative $FF\n");
		strBuilder.append("BOUCLE 		STA 		,X+ 			; Chargement et incrémentation du pointeur X\n");
		strBuilder.append("			CMPA 		#$80 			; Si donnée = $80 fin des données négatives\n");
		strBuilder.append("			BEQ 		POSITIF 		;\n");
		strBuilder.append("			DECA 						; Décrémentation de la donnée\n");
		strBuilder.append("			BRA 		BOUCLE 			;\n");
		strBuilder.append("			LDA 		#$00 			; 1ere donnée positive\n");
		strBuilder.append("BOUCLE1 	STA 		,Y+ 			; Chargement et incrémentation du pointeur\n");
		strBuilder.append("			CMPA 		#$7F 			; Si donnée = $7F fin des données positives\n");
		strBuilder.append("			BEQ 		FIN 			;\n");
		strBuilder.append("			INCA 						; Incrémentation de la donnée\n");
		strBuilder.append("			BRA 		BOUCLE1 		;\n");
		strBuilder.append("FIN 		SWI 						;\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	} 

/* 
	public void empty() {
		StringBuilder strBuilder = new StringBuilder();
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
	} 
*/
}