public class IPCutter {
    private String IP;
    public IPCutter(String ip){
        IP = ip;
    }

    public int[] cutter(){
        String[] IPArr = IP.split("\\.");
        int[] IPInts = new int[IPArr.length];
        for(int i = 0;i < IPArr.length;i++)
        {
            IPInts[i] = Integer.parseInt(IPArr[i]);
        }
        return  IPInts;
    }
}

class Main{
    public static void main(String[] args)
    {
        IPCutter test = new IPCutter("192.168.1.1");
        int[] out = test.cutter();
        for(int i = 0;i < out.length;i++)
        {
            System.out.println(out[i]);
        }
    }
}
