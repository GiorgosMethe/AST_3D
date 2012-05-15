package kinematics;

import perceptor.HingeJointPerceptor;
import agent.NAOConstraints;

public class HeadPosition {
	
	
	public static JointPosition2D Calculate(){
		
		
		JointPosition2D footposition= new JointPosition2D(0, 0);
		JointPosition2D JointPosition2DLegR = DirectKinematics.CalculatePosition(footposition, NAOConstraints.LegHeight, HingeJointPerceptor.getRlj5());
		JointPosition2D JointPosition2DUpperLegR = DirectKinematics.CalculatePosition(JointPosition2DLegR, NAOConstraints.UpperLegHeight, HingeJointPerceptor.getRlj4());
		JointPosition2D JointPosition2DBodyR = DirectKinematics.CalculatePosition(JointPosition2DUpperLegR, NAOConstraints.bodyHeight, HingeJointPerceptor.getRlj3());
		
		JointPosition2D JointPosition2DLegL = DirectKinematics.CalculatePosition(footposition, NAOConstraints.LegHeight, HingeJointPerceptor.getRlj5());
		JointPosition2D JointPosition2DUpperLegL = DirectKinematics.CalculatePosition(JointPosition2DLegL, NAOConstraints.UpperLegHeight, HingeJointPerceptor.getRlj4());
		JointPosition2D JointPosition2DBodyL = DirectKinematics.CalculatePosition(JointPosition2DUpperLegL, NAOConstraints.bodyHeight, HingeJointPerceptor.getRlj3());
		
		float JointPosition2DHeadX=(JointPosition2DBodyR.PositionX+JointPosition2DBodyL.PositionX)/2;
		float JointPosition2DHeadY=(JointPosition2DBodyR.PositionY+JointPosition2DBodyL.PositionY)/2;
		
		JointPosition2D JointPosition2DHead=new JointPosition2D(JointPosition2DHeadX, JointPosition2DHeadY);
		
		
		return JointPosition2DHead;

	}

}
