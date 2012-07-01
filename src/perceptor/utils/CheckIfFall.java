package perceptor.utils;

import motion.old.MotionTrigger;
import motion.xml.MotionPlaying;
import motion.xml.WalkLeaning;
import perceptor.sensors.Accelerometer;
import perceptor.sensors.ForceResistancePerceptor;
import perceptor.sensors.GyroScope;

public class CheckIfFall {

	public static double maxX=0,maxY=0,gyrX=0,gyrY=0,gyrZ=0;
	public static boolean fallen = false;
	
	public static void Check(){


		if(Math.abs(Accelerometer.getAccX())>Math.abs(maxX)){
			maxX=Accelerometer.getAccX();
		}
		
		if(Math.abs(Accelerometer.getAccY())>Math.abs(maxY)){
			maxY=Accelerometer.getAccY();
		}
		
//		if(ForceResistancePerceptor.ForcePerceptors.size() != 0){
//			
//			for(int i=0;i<ForceResistancePerceptor.ForcePerceptors.size();i++){
//				System.out.println(ForceResistancePerceptor.ForcePerceptors.elementAt(i).getName()+
//						" "+ForceResistancePerceptor.ForcePerceptors.elementAt(i).getForce().getX()+
//						" "+ForceResistancePerceptor.ForcePerceptors.elementAt(i).getForce().getY()+
//						" "+ForceResistancePerceptor.ForcePerceptors.elementAt(i).getForce().getZ());
//			}
//			
//		}
				

		if(Math.abs(GyroScope.getAngleX())>Math.abs(gyrX)){
			gyrX=GyroScope.getAngleX();
		}
		
		if(Math.abs(GyroScope.getAngleY())>Math.abs(gyrY)){
			gyrY=GyroScope.getAngleY();
		}
		
		if(Math.abs(GyroScope.getAngleZ())>Math.abs(gyrZ)){
			gyrZ=GyroScope.getAngleZ();
		}

		if((Math.abs(gyrX)+Math.abs(gyrY)+Math.abs(gyrZ))>500){
			System.err.println("EPESAAAAAAAAAAAAAAAAAAAAAA");
			MotionTrigger.setMotion("");
			
			if(MotionPlaying.getMotionName() == null){
				MotionTrigger.setMotion("stand_back");
			}else if(MotionPlaying.getMotionName().equalsIgnoreCase("stand_back")){
				gyrX=0;
				gyrY=0;
				gyrZ=0;
			}
			
			
		}else{
			
			MotionTrigger.setMotion("Forwards50");
			WalkLeaning.setLean("");
		}
		

	

	}

}
