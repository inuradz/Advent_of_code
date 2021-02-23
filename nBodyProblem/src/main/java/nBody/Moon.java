package nBody;

public class Moon {

    private Integer position_x;
    private Integer position_y;
    private Integer position_z;

    private Integer velocity_x;
    private Integer velocity_y;
    private Integer velocity_z;

    public Integer getPosition_x() {
        return position_x;
    }

    public Integer getPosition_y() {
        return position_y;
    }

    public Integer getPosition_z() {
        return position_z;
    }

    public Integer getVelocity_x() {
        return velocity_x;
    }

    public Integer getVelocity_y() {
        return velocity_y;
    }

    public Integer getVelocity_z() {
        return velocity_z;
    }

    Moon(Integer x, Integer y, Integer z, Integer vel_x,Integer vel_y, Integer vel_z){
        position_x = x;
        position_y = y;
        position_z = z;

        velocity_x = vel_x;
        velocity_y = vel_y;
        velocity_z = vel_z;
    }

    public void applyGravity(Moon other){

        if(position_z < other.position_z){
            velocity_z++;
        } else if(position_z > other.position_z){
            velocity_z--;
        }

        if(position_y < other.position_y){
            velocity_y++;
        } else if(position_y > other.position_y){
            velocity_y--;
        }

        if(position_x < other.position_x){
            velocity_x++;
        } else if(position_x > other.position_x){
            velocity_x--;
        }

    }
    public void updatePosition(){
        position_x += velocity_x;
        position_y += velocity_y;
        position_z += velocity_z;
    }

    public Integer energy(){
        Integer potential_energy = Math.abs(position_x) + Math.abs(position_y) + Math.abs(position_z);
        Integer kinect_energy    = Math.abs(velocity_x) + Math.abs(velocity_y) + Math.abs(velocity_z);
        return potential_energy * kinect_energy;
    }

    @Override
    public String toString() {
        return String.format("pos=<x= %s, y= %s, z=%s>, vel=<x= %s, y= %s, z=%s>",position_x,position_y,position_z,velocity_x,velocity_y,velocity_z);
    }

}
