package cn.yuanyang.vm;

/**
 * 虚拟机
 */
public class VM {


    /**
     * 开启虚拟机
     *
     * @param insts 指令序列
     * @param data  数据
     */
    public void start(Inst[] insts, short[] data) {
        InstPointer ip = new InstPointer(insts);
        VMState state = new VMState(data);
        Executer executer = new Executer(ip);
        executer.execute(state);
    }

}
