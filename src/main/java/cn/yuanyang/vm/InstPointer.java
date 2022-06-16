package cn.yuanyang.vm;

/**
 * 指令指针
 */
public class InstPointer {

    private final Inst[] insts;

    private short currentPos = 0;

    public InstPointer(Inst[] insts) {
        this.insts = insts;
    }

    public Inst getInst() {
        if (insts == null || currentPos < 0 || currentPos >= insts.length) {
            throw new VMStateException("get ip error");
        }
        return insts[currentPos++];
    }

    public short getCurrentPos() {
        return currentPos;
    }

    public void jump(int step) {
        currentPos += step;
    }

    public void set(short newPos) {
        currentPos = newPos;
    }
}
