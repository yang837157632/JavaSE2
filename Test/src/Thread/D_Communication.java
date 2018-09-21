package Thread;

/**
 * Created by Star Yang on 2016/11/22.
 */
public class D_Communication {

    public static void main(String[] args){

        final Business business = new Business();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i= 0;i<100;i++){
                    business.sub(i);
                }
            }
        }).start();


        for(int i= 0;i<100;i++){
            business.main(i);
        }
    }

}

class Business{

    private boolean mainFlag = true;

    public synchronized void sub(int i){
        while(mainFlag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int j=0;j<=10;j++){
            System.out.println("sub..." + j + "...loop..." + i);
        }
        mainFlag = true;
        this.notify();
    }

    public synchronized void main(int i){
        while(!mainFlag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int j=0;j<=20;j++){
            System.out.println("main..."+j+"...loop..."+i);
        }
        mainFlag = false;
        this.notify();
    }

}
