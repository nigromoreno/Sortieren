
/**
 * Write a description of class InsertionSort here.
 * 
 * @author Simon Gebert 
 * @version 2017-02-19
 */
public class InsertionSort extends BasicSort implements ISorter
{
    int curMax, curI, curK;

    /**
     * Constructor
     */
    public InsertionSort(SortCanvas p )
    {
        super(p);        
    }

    /**
     * sorts the data loaded in canvas
     * to animate and highlight the process, use
     *   canvas.hlA, canvas.hlB, canvas.hlC, canvas.hlD : assign index of element to be highlighted by eihter color A,B,C or D).
     *   canvas.redraw() : force redraw of the canvas (changes will be updated on canvas).
     *   canvas.delay() : canvas will be redrawn about every 60fps. Delay redraw for (initially) 1 second. 
     *                    canvas.delay(period: int) will delay for period milliseconds.
     *   cavas.reset() : reset highlighted entries to none.
     */
    public void sort(){
        int[] data = canvas.getData();

        for(curK=0; curK < data.length - 1; curK++) 
        {
            getMax(); 
            if (curMax < 0) continue; 
            if(curK!=curMax){
                swap(curK, curMax); 
            }
            canvas.hlB=curK;
            canvas.redraw(); canvas.delay();
        }

        canvas.reset();
        canvas.redraw();
    }

    private int getMax(){
        int[] data = canvas.getData();

        if( data.length < curK ) return -1; 
        curMax = curK;
        for(curI=curK+1; curI < data.length; curI++){
            if (compare( curMax, curI ) < 0 ){
                curMax = curI; 
            }
            canvas.hlB=curK; canvas.hlC=curI;
            canvas.redraw(); canvas.delay();
        }

        return curMax; 
    }

}
