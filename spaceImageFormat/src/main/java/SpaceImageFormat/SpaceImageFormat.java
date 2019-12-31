package SpaceImageFormat;
import java.awt.image.BufferedImage;
import java.util.*;

public class SpaceImageFormat {

    List<List<List<Integer>>> image_buffer;
    Integer height;
    Integer width;


    SpaceImageFormat(Integer height, Integer width, Collection<Integer> data){
        image_buffer = new LinkedList<>();
        this.height = height;
        this.width = width;
        Queue<Integer> pixels = new LinkedList<>(data);
        //Process until all the pixels are in a layer
        Integer i;
        Integer j;
        List<List<Integer>> layer;
        while(!pixels.isEmpty()){
            layer = new ArrayList<>(this.height);
            for(i = 0; i < this.height; i++){
                List<Integer> row = new ArrayList<>(width);
                for(j = 0; j < width; j++){
                    row.add(pixels.poll());
                }
                layer.add(row);
            }
            image_buffer.add(layer);
        }
    }

    Integer getNumberOfLayers(){
        return image_buffer.size();
    }

    List<List<Integer>> getLayer(Integer layer){
        return image_buffer.get(layer);
    }

    BufferedImage getImage(){

        List<List<Integer>> image= new ArrayList<>();
        Iterator<List<List<Integer>>> it = image_buffer.iterator();
        List<List<Integer>> layer = it.next();
        for(List<Integer> fi: layer){
            List<Integer> row = new ArrayList<>(fi);
            image.add(row);
        }
        Integer i = 0;
        Integer j = 0;
        while(it.hasNext()){
            layer = it.next();
            for(i=0;i<this.height;i++){
                for(j=0;j<this.width;j++){
                    if(image.get(i).get(j) == 2){
                        image.get(i).set(j,layer.get(i).get(j));
                    }
                }
            }
        }
        BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        for(i=0;i<this.height;i++){
            for(j=0;j<this.width;j++){
                switch (image.get(i).get(j)){
                    case 0:
                        bi.setRGB(j,i,0xFF000000);
                        break;
                    case 1:
                        bi.setRGB(j,i,0xFFFFFFFF);
                        break;
                    case 2:
                        bi.setRGB(j,i,0xFF999999);
                        break;
                }
            }
        }
        return bi;
    }


}
