package cn.yuanyang.vm;

/**
 * 虚拟机内部错误
 */
public class VMStateException extends RuntimeException {

    public VMStateException(String message) {
        super(message);
    }
}
