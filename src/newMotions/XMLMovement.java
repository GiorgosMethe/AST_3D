package newMotions;

import connection.ServerCyrcles;

public class XMLMovement {
	
	public String execute(String name){
		
		Motion motion = null;
		Phase phase;
		
		int MoveCategory=0;
		//int MoveCategory=1; --Starts a new motion
		//int MoveCategory=2; --The same motion and the same phase
		//int MoveCategory=3; --same motion different phase
		//int MoveCategory=4; -- new motion requested
		
		System.out.println(MotionPlaying.getMotionName());
		
		System.out.println(MotionPlaying.getMotionPhase());
		
		if(MotionPlaying.getMotionName()==null){
			
			motion=GetMotion.Get(name);
			
			if(motion!=null){
				
				MotionPlaying.setMotionName(motion.getName());
				MotionPlaying.setMotionPhase(motion.getFirstPhase());
				MotionPlaying.setStartCyrcle(ServerCyrcles.getCyrclesNow());
				MoveCategory=1;
				
			}else{
				
				
				
			}
			
		}else{
			
			motion=GetMotion.Get(name);
			
			if(name.equalsIgnoreCase(MotionPlaying.getMotionName())){
				
				System.out.println("the same motion");
				MoveCategory=2;
				phase=GetPhase.get(motion, MotionPlaying.getMotionPhase());
				if((phase.getDuration()/20) <= (ServerCyrcles.getCyrclesNow()-MotionPlaying.getStartCyrcle())){
					MoveCategory=3;
					System.out.println("^^^^^^^^^^^^^^^^^^^^^^^");
					if(GetPhase.getNext(motion, MotionPlaying.getMotionPhase())==null){
						System.out.println("motion ended");
						return "(lae4 0)(rae4 0)(lae3 0)(rae3 0)(lae2 0)(rae2 0)(lae1 0)(rae1 0)(rle1 0)(rle2 0)(rle3 0)(rle4 0)(rle5 0)(rle6 0)(lle1 0)(lle2 0)(lle3 0)(lle4 0)(lle5 0)(lle6 0)";
					}
					MotionPlaying.setMotionPhase(GetPhase.getNext(motion, MotionPlaying.getMotionPhase()));
					MotionPlaying.setStartCyrcle(ServerCyrcles.getCyrclesNow());
				}
				
			}else{
				
				System.out.println("new motion needs handle");
				MoveCategory=4;
				
			}
			
			
			
			
		}
		
		
		if(MoveCategory==1 || MoveCategory==3){
			System.out.println("motion performed---"+MotionPlaying.getMotionPhase() );
			return MoveJoints.performMove(GetPhase.get(motion, MotionPlaying.getMotionPhase()));
			
		}
		
		
				
		return "";
		
	}

}
