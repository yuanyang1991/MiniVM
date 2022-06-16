package cn.yuanyang.vm;

public class Main {


    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i != 200; i++) {
            sum += i;
        }
        System.out.println(sum);


        Inst[] insts = new Inst[]{
                new Inst(Executer.ILD, (short) 0, (short) 0, Executer.FNA), // sum = 0
                new Inst(Executer.ILD, (short) 1, (short) 0, Executer.FNA), // i = 0
                new Inst(Executer.ILD, (short) 2, (short) 200, Executer.FNA), // temp = 100
                new Inst(Executer.ICOM, (short) 1, (short) 2, Executer.FNA), // value = i == temp,put value to state
                new Inst(Executer.ILD, (short) 3, (short) 11, Executer.FEQ), // if equals, goto out
                new Inst(Executer.ILD, (short) 3, (short) 7, Executer.FNE), // if no equals, goto add
                new Inst(Executer.ILDIP, (short) 3, (short) 0, Executer.FNA), // set ip to new pos
                new Inst(Executer.IADD, (short) 0, (short) 1, Executer.FNA), // sum + i
                new Inst(Executer.IADD1, (short) 1, (short) 0, Executer.FNA), // i++
                new Inst(Executer.ILD, (short) 4, (short) 4, Executer.FNA),
                new Inst(Executer.ILDIP, (short) 4, (short) 0, Executer.FNA),
                new Inst(Executer.IOUT, (short) 0, (short) 0, Executer.FNA), // out sum
                new Inst(Executer.ISTOP, (short) 0, (short) 0, Executer.FNA), // exit
        };

        short[] data = new short[16];
        VM vm = new VM();
        vm.start(insts, data);
    }
}
