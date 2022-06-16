package cn.yuanyang.vm;

/**
 * 虚拟机执行器
 */
public class Executer {

    public static final short IADD = 1; // 加法
    public static final short ISUB = 2; // 减法
    public static final short ICOM = 3; // 判断
    public static final short IJMP = 4; // 跳转
    public static final short IMOV = 5; // 赋值
    public static final short ISTIP = 6; // 保存IP
    public static final short ILDIP = 7; // 设置IP
    public static final short ILD = 8; // 加载一个立即数
    public static final short IOUT = 9; // 输出
    public static final short IADD1 = 10; // 执行i++操作
    public static final short ISTOP = 255; // 挂起虚拟机


    public static final short FNA = 0;
    public static final short FEQ = 1;
    public static final short FNE = 2;

    private final InstPointer ip;

    public Executer(InstPointer ip) {
        this.ip = ip;
    }

    public void execute(VMState state) {
        while (true) {
            Inst inst = ip.getInst();
            if (inst.flag != FNA && inst.flag != state.getFlag()) {
                continue;
            }
            switch (inst.code) {
                case IADD: {
                    short result = (short) (state.getValue(inst.p1) + state.getValue(inst.p2));
                    state.setValue(inst.p1, result);
                }
                break;
                case ISUB: {
                    short result = (short) (state.getValue(inst.p1) - state.getValue(inst.p2));
                    state.setValue(inst.p1, result);
                }
                break;
                case ICOM:
                    state.setFlag((state.getValue(inst.p1) == state.getValue(inst.p2)) ? FEQ : FNE);
                    break;
                case IJMP:
                    ip.jump(inst.p1);
                    break;
                case IMOV:
                    state.setValue(inst.p1, state.getValue(inst.p2));
                    break;
                case ISTIP: // 保存IP到p1
                    state.setValue(inst.p1, ip.getCurrentPos());
                    break;
                case ILDIP: // 将ip设置为p1
                    ip.set(state.getValue(inst.p1));
                    break;
                case ILD: // 在满足情况下，将立即数p2放入p1
                    if (state.getFlag() == FNA || state.getFlag() == inst.flag) {
                        state.setValue(inst.p1, inst.p2);
                    }
                    break;
                case IOUT:
                    System.out.println(state.getValue(inst.p1));
                    break;
                case ISTOP:
                    return;
                case IADD1:
                    state.setValue(inst.p1, (short) (state.getValue(inst.p1) + 1));
                    break;
                default:
                    throw new VMStateException("do not support inst:" + inst.code);

            }
        }
    }
}
