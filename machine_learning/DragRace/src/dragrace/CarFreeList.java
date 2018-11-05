package dragrace;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

/**
 * - List of available images (image names e.g. "car1.png")
 *
 */
public class CarFreeList extends ArrayList<String> {

    File folder = new File("src/dragrace/images");
    File[] listOfFiles = folder.listFiles();

    CarFreeList() {
        // add image names to our ArrayList
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                add(listOfFile.getName());
            }
        }
        Collections.shuffle(this);
    }
}
