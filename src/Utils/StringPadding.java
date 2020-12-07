package Utils;

public class StringPadding {

    public static byte padding(int numberOfPads)
    {
        byte ret = 0 ;
        for(int i = 1; i <= numberOfPads; i++)
        {
            if(i==1)
                ret = 0 ;
            else
                ret += 0x00 ;
        }
        return ret;
    }
}
