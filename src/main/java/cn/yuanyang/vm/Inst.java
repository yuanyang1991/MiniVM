package cn.yuanyang.vm;

/**
 * 单条指令
 */
public class Inst {

    /**
     * 指令
     */
    public final short code;

    /**
     * 第一个操作数
     */
    public final short p1;

    /**
     * 第二个操作数
     */
    public final short p2;

    public final short flag;

    public Inst(short code, short p1, short p2, short flag) {
        this.code = code;
        this.p1 = p1;
        this.p2 = p2;
        this.flag = flag;
    }
}
