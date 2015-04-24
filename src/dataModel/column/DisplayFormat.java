package dataModel.column;

/*****************************************************************************
 *
 *          Column display format
 *
 *          width in pixels for the display
 *
 */

public enum DisplayFormat {

    SMALL(40), REGULAR(80), MEDIUM(120), WIDE(240), EXTRA_WIDE(360);

    private int width;

    DisplayFormat(int width){

        this.width = width;
    }


    public int getWidth() {

        return width;
    }
}
