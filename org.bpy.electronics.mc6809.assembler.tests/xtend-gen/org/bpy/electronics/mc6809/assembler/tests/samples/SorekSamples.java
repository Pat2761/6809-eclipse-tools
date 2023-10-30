/**
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
 */
package org.bpy.electronics.mc6809.assembler.tests.samples;

import com.google.inject.Inject;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(AssemblerInjectorProvider.class)
@SuppressWarnings("all")
public class SorekSamples {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  @Test
  public void testSample173() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(";******************************************************");
      _builder.newLine();
      _builder.append("; réception de donnée avec ligne série");
      _builder.newLine();
      _builder.append("; vérifications diverses (format, parité, surcharge)");
      _builder.newLine();
      _builder.append("; contrôle du transmetteur par ligne RTS");
      _builder.newLine();
      _builder.append(";******************************************************");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ORG \t\t$8000 \t\t\t\t;");
      _builder.newLine();
      _builder.append(";------adresses des registres du 6850");
      _builder.newLine();
      _builder.append("RCRIMP \t\tEQU \t\t$EC00 \t\t\t\t; reg. contrôle");
      _builder.newLine();
      _builder.append("RSRIMP \t\tEQU \t\t$EC00 \t\t\t\t; reg. Etat");
      _builder.newLine();
      _builder.append("RRXIMP \t\tEQU \t\t$EC01 \t\t\t\t; reg. Réception");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDB \t\t#%01000011 \t\t\t; initialisation programmée avec");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t\t\t\t");
      _builder.append("; RTS=1 (ligne RTS à -12v)");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("STB \t\tRCRIMP \t\t\t\t; registre contrôle");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDX \t\t#$8100 \t\t\t\t; adrs rangement données");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDY \t\t#10 \t\t\t\t; nb d\'octet à recevoir");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LEAY \t\t-1,Y \t\t\t\t; écarter dernière donnée");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t\t\t\t");
      _builder.append(";");
      _builder.newLine();
      _builder.append(";------Configurer le mode de réception et actionner ligne RTS");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDB \t\t#%00000001 \t\t\t; 7 Bits,parité paire,2 stop, clock 1/16");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t\t\t\t");
      _builder.append("; + RTS |=0 (ligne RTS= +12v)");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("STB \t\tRCRIMP \t\t\t\t;");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t\t\t\t");
      _builder.append(";");
      _builder.newLine();
      _builder.append(";------Réception données avec vérifications diverses");
      _builder.newLine();
      _builder.append("ATDON \t\tLDB \t\tRSRIMP \t\t\t\t; reg. Etat");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("BITB \t\t#%00000001 \t\t\t; Examen bit réception");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("BNE \t\tVERIF \t\t\t\t; SR0=1, alors vérification");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("BITB \t\t#%00000100 \t\t\t; examen bit DCD");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("BEQ \t\tATDON \t\t\t\t; SR2=0, alors ATtente DONnée");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("BRA \t\tTMDCD \t\t\t\t; --> TraiteMent DCD");
      _builder.newLine();
      _builder.append(";------Vérification format, parité, surcharge");
      _builder.newLine();
      _builder.append("VERIF \t\tBITB \t\t#%01110000 \t\t\t; test global");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("BEQ \t\tRXDON \t\t\t\t; sans erreur, --> Rx réception donnée");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("BITB \t\t#%00010000 \t\t\t; erreur format ?");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("BEQ \t\t*+4 \t\t\t\t; sinon test suivant adrs +4");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("BRA \t\tERFMT \t\t\t\t; --> erreur format");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("BITB \t\t#%01000000 \t\t\t; erreur parité ?");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("BEQ \t\t*+4 \t\t\t\t; sinon --> erreur surcharge");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("BRA \t\tERPAR \t\t\t\t; --> erreur PARité");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("BRA \t\tERSCH \t\t\t\t; --> erreur SurCHarge");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t\t\t\t");
      _builder.append(";");
      _builder.newLine();
      _builder.append(";------Aucune erreur détectée, lecture donnée");
      _builder.newLine();
      _builder.append("RXDON \t\tLDA \t\tRRXIMP \t\t\t\t; lecture reg. réception");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("STA \t\t,X+ \t\t\t\t; rangement donnée épuisé ?");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LEAY \t\t-1,Y \t\t\t\t; Nb données épuisé ?");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("BNE \t\tATDON \t\t\t\t;");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t\t\t\t");
      _builder.append(";");
      _builder.newLine();
      _builder.append(";------Inhibition de l\'émetteur");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDB \t\t#%01000001 \t\t\t; RTS |=1 (ligne RTS à -12v)");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("STB \t\tRCRIMP \t\t\t\t; reg. contrôle");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t\t\t\t");
      _builder.append(";");
      _builder.newLine();
      _builder.append(";------Lecture derniére donnée en cours");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDB \t\tRSRIMP \t\t\t\t; reg. Etat");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("RORB \t\t\t\t\t\t\t;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("BCC \t\t*-4 \t\t\t\t;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDA \t\tRRXIMP \t\t\t\t;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("STA \t\t,X+ \t\t\t\t; rangement");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("SWI \t\t\t\t\t\t\t;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append(";");
      _builder.newLine();
      _builder.append(";------Si une ou plusieurs erreurs sont présentes,");
      _builder.newLine();
      _builder.append(";------elles sont indiquées dans le registre B");
      _builder.newLine();
      _builder.append("ERFMT \t\tSWI \t\t\t\t\t\t\t;");
      _builder.newLine();
      _builder.append("ERPAR \t\tSWI \t\t\t\t\t\t\t;");
      _builder.newLine();
      _builder.append("ERSCH \t\tSWI \t\t\t\t\t\t\t;");
      _builder.newLine();
      _builder.append("TMDCD \t\tSWI \t\t\t\t\t\t\t;");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void checkProg1_A() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\t\t\t");
      _builder.append("ORG \t\t$0000 \t\t\t\t; Début du programme");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDX \t\t#$0100 \t\t\t\t; Début de table");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDA \t\t#$00 \t\t\t\t; 1ere données $00");
      _builder.newLine();
      _builder.append("Boucle \t\tSTA \t\t,X+ \t\t\t\t; Chargement et incrémentation du pointeur");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPA \t\t#$FF \t\t\t\t; Dernière donnée = $FF alors fin de programme");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("BEQ \t\tFin \t\t\t\t;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("INCA \t\t\t\t\t\t\t; Incrémentation de la donnée");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("BRA \t\tBoucle \t\t\t\t;");
      _builder.newLine();
      _builder.append("Fin \t\tSWI \t\t\t\t\t\t\t;");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void checkProg1_B() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\t\t\t");
      _builder.append("ORG \t\t$0000 \t\t\t; Début du programme");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDX \t\t#$0200 \t\t\t; Début 1ere donnée négative");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDY \t\t#$0280 \t\t\t; Début 1ere donnée positive");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDA \t\t#$FF \t\t\t; 1ere donnée négative $FF");
      _builder.newLine();
      _builder.append("BOUCLE \t\tSTA \t\t,X+ \t\t\t; Chargement et incrémentation du pointeur X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPA \t\t#$80 \t\t\t; Si donnée = $80 fin des données négatives");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("BEQ \t\tPOSITIF \t\t;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("DECA \t\t\t\t\t\t; Décrémentation de la donnée");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("BRA \t\tBOUCLE \t\t\t;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDA \t\t#$00 \t\t\t; 1ere donnée positive");
      _builder.newLine();
      _builder.append("BOUCLE1 \tSTA \t\t,Y+ \t\t\t; Chargement et incrémentation du pointeur");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPA \t\t#$7F \t\t\t; Si donnée = $7F fin des données positives");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("BEQ \t\tFIN \t\t\t;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("INCA \t\t\t\t\t\t; Incrémentation de la donnée");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("BRA \t\tBOUCLE1 \t\t;");
      _builder.newLine();
      _builder.append("FIN \t\tSWI \t\t\t\t\t\t;");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
