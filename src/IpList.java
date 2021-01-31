/**
 * 实现如下的IP地址黑白名单过滤功能。
 */

/**
 * 要求
 * 1.'isInList'操作为常数级时间复杂度
 * 2.'isInList'内部操作完全基于内存，不得有网络或文件读取; 对象初始化部分如构造函数则不受此限制(如初始化时可从文件中load ip名单列表)
 * 3.让此工具所能支持的ip列表数量尽可能大(甚至能否覆盖整个ipv4地址空间?), 内存占用尽可能小
 * 4.此工具可能在多线程环境被使用
 */
public interface IpList {
    /**
     * 判断指定的ipv4地址是否在当前名单中
     *
     * @param ip 指定的ip地址值(v4)
     * @return true: 在名单中， false: 不在名单中
     */
    boolean isInList(String ip);
}

