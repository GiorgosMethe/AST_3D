package action.vision;

import localization.Coordinate;

public class KickSuccess {

	public static boolean Check(Coordinate start,Coordinate end){

		float movementX= (float) Math.abs(end.X - start.X);
		float movementY= (float) Math.abs(end.Y - start.Y);

		float move = (float) Math.sqrt(Math.pow(movementX, 2)+Math.pow(movementY, 2));


		if(move>1){
			return true;
		}else{
			return false;
		}

	}

}
