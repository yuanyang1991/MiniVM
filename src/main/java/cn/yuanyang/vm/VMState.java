package cn.yuanyang.vm;

/**
 * 虚拟机当前状态
 */
public class VMState {

    /**
     * 当前数据
     */
    private final short[] data;

    /**
     * 虚拟机最后判断的标志
     */
    private short flag;

    public VMState(short[] data) {
        this.data = data;
    }

    public short getFlag() {
        return flag;
    }

    public void setFlag(short flag) {
        this.flag = flag;
    }

    public void setValue(int index, short value) {
        if (data == null || index < 0 || index > data.length) {
            throw new VMStateException("set data error");
        }
        data[index] = value;
    }

    public short getValue(int index) {
        if (data == null || index < 0 || index > data.length) {
            throw new VMStateException("set data error");
        }
        return data[index];
    }
}
