package gilardoniraul;

import robocode.*;

public class JuniorRobot extends AdvancedRobot {
  
  public void run() {
  	 
    while (true) {
      turnRadarRight(360);
      turnGunRight(360);
      hideOrTurnToWall();
      scan();
      ahead(50);
 
      if (getGunHeat() > 0.6) {
        hideOrTurnToWall();
      }
    }
  }
  
  public void onScannedRobot(ScannedRobotEvent e) {
    double bearing = e.getBearing();
    double distance = e.getDistance();
    double absBearing = bearing + getHeading();
    
    if (distance > 5e3) {
      distance /= 2.5d;
    }
    
    fire(5);
    
    double gunDelta = robocode.util.Utils.normalAbsoluteAngle(absBearing - getGunHeading());
    turnGunRight(gunDelta);
    back(distance * 2);
  }
  private void hideOrTurnToWall() {
    double rand = Math.random() * 100 + 20;
    turnRight(rand * getRandomDir());
	ahead(rand);
	turnRight(90 * getRandomDir());
    ahead(rand); 
	out.println("GOPFERDAMMINOEMALE");

  }

  private char getRandomDir() {
    if (Math.random() >= 0.5) {
      return 5 ;
    }
	return 10 ;
  }

}