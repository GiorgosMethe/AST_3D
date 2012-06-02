/***********************************************************************************
 * Copyright 2012, Technical University of Crete
 * Academic Year 2011-2012
 *
 * Thesis Project
 *
 * @author Methenitis Georgios Student ID:2006030085	
 *
 * Abstract: Player Behavior and Team Strategy for the RoboCup 3D Simulation League
 * Start date: 25-04-2012											 
 * End date  : xx-xx-2012
 ***********************************************************************************/
package motion.utils;

import perceptor.joints.HingeJointPerceptor;

public class GetNormalJointValueDegrees {

	float alrValue;
	float chnValue = 0;
	float ValueToDeg = 0;
	
	public float Get(String name, float value) {

		if (name.equalsIgnoreCase("he1")) {

			alrValue = HingeJointPerceptor.getHj1();		

		} else if (name.equalsIgnoreCase("he2")) {

			alrValue = HingeJointPerceptor.getHj2();			
			

		} else if (name.equalsIgnoreCase("lae1")) {

			alrValue = HingeJointPerceptor.getLaj1();

		} else if (name.equalsIgnoreCase("lae2")) {

			alrValue = HingeJointPerceptor.getLaj2();

		} else if (name.equalsIgnoreCase("lae3")) {

			alrValue = HingeJointPerceptor.getLaj3();

		} else if (name.equalsIgnoreCase("lae4")) {

			alrValue = HingeJointPerceptor.getLaj4();

		} else if (name.equalsIgnoreCase("lle1")) {

			alrValue = HingeJointPerceptor.getLlj1();		

		} else if (name.equalsIgnoreCase("lle2")) {

			alrValue = HingeJointPerceptor.getLlj2();

		} else if (name.equalsIgnoreCase("lle3")) {

			alrValue = HingeJointPerceptor.getLlj3();

		} else if (name.equalsIgnoreCase("lle4")) {

			alrValue = HingeJointPerceptor.getLlj4();

		} else if (name.equalsIgnoreCase("lle5")) {

			alrValue = HingeJointPerceptor.getLlj5();

		} else if (name.equalsIgnoreCase("lle6")) {

			alrValue = HingeJointPerceptor.getLlj6();

		} else if (name.equalsIgnoreCase("rle1")) {

			alrValue = HingeJointPerceptor.getRlj1(); 
			
		} else if (name.equalsIgnoreCase("rle2")) {

			alrValue = HingeJointPerceptor.getRlj2();

		} else if (name.equalsIgnoreCase("rle3")) {

			alrValue = HingeJointPerceptor.getRlj3();

		} else if (name.equalsIgnoreCase("rle4")) {

			alrValue = HingeJointPerceptor.getRlj4();

		} else if (name.equalsIgnoreCase("rle5")) {

			alrValue = HingeJointPerceptor.getRlj5();

		} else if (name.equalsIgnoreCase("rle6")) {

			alrValue = HingeJointPerceptor.getRlj6();

		} else if (name.equalsIgnoreCase("rae1")) {

			alrValue = HingeJointPerceptor.getRaj1();

		} else if (name.equalsIgnoreCase("rae2")) {

			alrValue = HingeJointPerceptor.getRaj2();

		} else if (name.equalsIgnoreCase("rae3")) {

			alrValue = HingeJointPerceptor.getRaj3();

		} else if (name.equalsIgnoreCase("rae4")) {

			alrValue = HingeJointPerceptor.getRaj4();

		}
		chnValue = value-alrValue;
		if (Math.abs(chnValue)<0.01){
			return (float) 0.0;
		}else{
			return (float) chnValue;
		}
		
	}	
	
}
