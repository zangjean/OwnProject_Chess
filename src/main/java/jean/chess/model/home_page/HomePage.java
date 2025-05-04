package jean.chess.model.home_page;

import java.net.URL;

public class HomePage {
    private int pref_width;
    private int pref_height;
    private int min_width;
    private int min_height;
    private int max_width;
    private int max_height;

    private int ratio;

    private URL url_home_page;

    private URL url_sheetstyle;


    public HomePage(int width, int height, int ratio,String path_home_page,String path_sheetstyle) {
        this.pref_height = height;
        this.pref_width = width;
        this.min_height = height/ratio;
        this.min_width = width/ratio;
        this.max_height = height*ratio;
        this.max_width = width*ratio;
        this.ratio = ratio;
        this.url_home_page = getClass().getResource(path_home_page);
        this.url_sheetstyle = getClass().getResource(path_sheetstyle);
    }



    public int getRatio(int ratio) {
        return this.ratio = ratio;
    }

    public int getPref_width() {
        return pref_width;
    }

    public int getPref_height() {
        return pref_height;
    }

    public int getMin_width() {
        return min_width;
    }

    public int getMin_height() {
        return min_height;
    }

    public int getMax_width() {
        return max_width;
    }

    public int getMax_height() {
        return max_height;
    }


    public int getRatio() {
        return ratio;
    }

    public URL getUrl_home_page() {
        return url_home_page;
    }

    public URL getUrl_sheetstyle() {
        return url_sheetstyle;
    }
}
