import becker.robots.City;
import becker.robots.Direction;
import becker.robots.IPredicate;
import becker.robots.RobotSE;

public class APBot extends RobotSE {

	/**
	 * 
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 * @param nT
	 */
	public APBot(City arg0, int arg1, int arg2, Direction arg3, int nT) {
		super(arg0, arg1, arg2, arg3, nT);
		// TODO Auto-generated constructor stub
	}

	/**
	 * paints the interior area of a given polygon
	 **/
	public void paint() {
		if (isSouthClear()) { // moves south if no thing to the south
			faceSouth();
			move();
			putThing(); // reduction step
			paint(); // recursive call
			faceNorth();  //boomerang
			move();
		}
	}

	private boolean isSouthClear() {
		//move south
		faceSouth();
		move();
		//check to see if beside thing - bool
		boolean check = !isBesideThing(IPredicate.aThing);
		//move back
		turnAround();
		move();

		//return check value
		return check;
	}

	/**
	 * faces robot south regardless of starting direction
	 */
	private void faceSouth() {
		if (!isFacingSouth()) { // if not facing south
			turnLeft();
			faceSouth();
		}
	}

	/**
	 * faces robot NORTH regardless of starting direction
	 */
	private void faceNorth() {
		if (!isFacingNorth()) { // if not facing NORTH
			turnLeft();
			faceNorth();
		}
	}

}
