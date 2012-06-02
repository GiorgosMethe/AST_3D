package motion.kinematics;

import perceptor.joints.HingeJointPerceptor;
import agent.Constraints;

public class HeadPosition {
	
	
	public static JointPosition2D Calculate(){
		
		
		JointPosition2D footposition= new JointPosition2D(0, 0);
		JointPosition2D JointPosition2DLegR = DirectKinematics.CalculatePosition(footposition, Constraints.LegHeight, HingeJointPerceptor.getRlj5());
		JointPosition2D JointPosition2DUpperLegR = DirectKinematics.CalculatePosition(JointPosition2DLegR, Constraints.UpperLegHeight, HingeJointPerceptor.getRlj4());
		JointPosition2D JointPosition2DBodyR = DirectKinematics.CalculatePosition(JointPosition2DUpperLegR, Constraints.bodyHeight, HingeJointPerceptor.getRlj3());
		
		JointPosition2D JointPosition2DLegL = DirectKinematics.CalculatePosition(footposition, Constraints.LegHeight, HingeJointPerceptor.getLlj5());
		JointPosition2D JointPosition2DUpperLegL = DirectKinematics.CalculatePosition(JointPosition2DLegL, Constraints.UpperLegHeight, HingeJointPerceptor.getLlj4());
		JointPosition2D JointPosition2DBodyL = DirectKinematics.CalculatePosition(JointPosition2DUpperLegL, Constraints.bodyHeight, HingeJointPerceptor.getLlj3());
		
		float JointPosition2DHeadX=(JointPosition2DBodyR.PositionX+JointPosition2DBodyL.PositionX)/2;
		float JointPosition2DHeadY=(JointPosition2DBodyR.PositionY+JointPosition2DBodyL.PositionY)/2;
		
		JointPosition2D JointPosition2DHead=new JointPosition2D(JointPosition2DHeadX, JointPosition2DHeadY);
		
		
		return JointPosition2DHead;

	}

}
