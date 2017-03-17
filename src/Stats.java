public class Stats {

    private static boolean isPlay = true;
    private static boolean isPause = false;
    private static boolean isMenu = false;
    public static boolean isEnd = false;


    public static boolean isPlay(){
        return isPlay;
    }

    public static boolean isPause(){
        return isPause;
    }

    public static boolean isMenu(){
        return isMenu;
    }
    public static boolean isEnd(){
        return isEnd;
    }

    public static void startPlay(){
        isPlay = true;
    }
    public static void stopPlay(){
        isPlay = false;
    }

    public static void startPause(){
        isPause = true;
    }
    public static void stopPause(){
        isPause = false;
    }

    public static void startMenu(){
        isMenu = true;
    }
    public static void stopMenu(){
        isMenu = false;
    }

    public static void endGame(){
        isEnd = true;
        isPlay = false;
    }

    public static void startGame(){
        isEnd = false;
        isPlay = true;
    }

    public static void togglePause(){
        if(isPause){
            isPause = false;
        }else
            isPause = true;
    }

    public static void togglePlay(){
        if(isPlay){
            isPlay=false;
        }else
            isPlay=true;
    }

    public static void toggleMenu(){
        if(isMenu){
            isMenu = false;
        }else
            isMenu = true;
    }


}