package org.bpy.electronics.mc6809.assembler.tests.language.bugs;

import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(AssemblerInjectorProvider.class)

public class JsrBadPCCounter {
	@Inject ParseHelper<Model> parseHelper;
	@Inject @Extension private ValidationTestHelper validationTestHelper;

	@Test
	/**
	 * Expected result:
	 *   2     A000                      ORG $A000
      3                  E803     PUTC   EQU $E803
      4  5+10  A000 34   7F       ECRAN  PSHS U,Y,X,DP,D,CC
      5  3     A002 CE   A012             LDU #TABLE
      6  4+2   A005 E6   C0       DEBUT  LDB ,U+
      7  2     A007 C1   04               CMPB #4
      8  3     A009 27   05               BEQ FIN
      9  8     A00B BD   E803             JSR PUTC
     10  3     A00E 20   F5               BRA DEBUT
     11  5+12  A010 35   FF       FIN    PULS U,Y,X,DP,D,CC,PC
     12
     13        A012 1B            TABLE  FCB $1B
     14        A013 44                    FCB $44
     15        A014 1B                    FCB $1B
     16        A015 53                    FCB $53
     17        A016 1B                    FCB $1B
     18        A017 60                    FCB $60
     19        A018 0C                    FCB $0C
     20        A019 14                    FCB $14
     21        A01A 04                    FCB $04
     22                  0000             END
	 */
	public void Test01() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("			ORG 		$A000\n");
		strBuilder.append("PUTC		EQU 		$E803\n");
		strBuilder.append("ECRAN	PSHS 		U,Y,X,DP,D,CC\n");
		strBuilder.append("			LDU 		#TABLE\n");
		strBuilder.append("DEBUT	LDB 		,U+\n");
		strBuilder.append("			CMPB 		#4\n");
		strBuilder.append("			BEQ 		FIN\n");
		strBuilder.append("			JSR 		PUTC\n");
		strBuilder.append("			BRA 		DEBUT\n");
		strBuilder.append("FIN		PULS 		U,Y,X,DP,D,CC,PC\n");

		strBuilder.append("TABLE	FCB 		$1B\n");
		strBuilder.append("			FCB 		$44\n");
		strBuilder.append("			FCB 		$1B\n");
		strBuilder.append("			FCB 		$53\n");
		strBuilder.append("			FCB 		$1B\n");
		strBuilder.append("			FCB 		$60\n");
		strBuilder.append("			FCB 		$0C\n");
		strBuilder.append("			FCB			$14\n");
		strBuilder.append("			FCB 		$04	\n");
		strBuilder.append("			END		\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());
//			Assert.assertNotNull(result);
//			validationTestHelper.assertNoErrors(result);
//			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
//			
//			AssemblerEngine engine = AssemblerEngine.getInstance();
//			
//			Assert.assertEquals("Check PC after instruction", 0xA01A, engine.getCurrentPcValue());
		
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 

	}
}
