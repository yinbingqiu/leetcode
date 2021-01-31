package 链表常见算法;


import java.util.BitSet;

public class IPFiliterTest {
    /*** int的最大值只能表示到0x7fffffff,所以需要两个BitSet来存储高低位  ***/
    private static volatile BitSet low = new BitSet(Integer.MAX_VALUE);
    private static volatile BitSet high = new BitSet(Integer.MAX_VALUE);

    /**
     * 将每一个ip 子段转化为8位二进制数
     *
     * @param num
     * @return
     */
    private static String getLength8BinaryString(int num) {
        String binaryString = Integer.toBinaryString(num);
        int length = binaryString.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 8 - length; i++) {
            stringBuilder.append("0");
        }
        stringBuilder.append(binaryString);
        return stringBuilder.toString();
    }

    /**
     * 将IP地址字符串转换为int
     *
     * @param ip
     * @return
     */
    private static int ipv4ToInt(String ip) {
        if (ip == null || ip.equals("")) {
            throw new IllegalArgumentException("非法IP");
        }
        String[] arr = ip.split("\\.");
        if (arr == null || arr.length != 4) {
            throw new IllegalArgumentException("非法IP");
        }

        if ("128.0.0.0".equals(ip)) {
            return Integer.MIN_VALUE;
        }
        StringBuilder stringBuilder = new StringBuilder()
                .append(getLength8BinaryString(new Integer(arr[0])))
                .append(getLength8BinaryString(new Integer(arr[1])))
                .append(getLength8BinaryString(new Integer(arr[2])))
                .append(getLength8BinaryString(new Integer(arr[3])));

        String intString = stringBuilder.toString();
        if (intString.charAt(0) == '1') {
            /*** 单独处理下负数  ***/
            char[] chars = intString.toCharArray();
            chars[0] = '0';
            intString = new String(chars);
            return 0 - Integer.valueOf(intString, 2).intValue();
        }
        return Integer.valueOf(intString, 2).intValue();
    }

    public static boolean addWhiteIpAddress(String ip) {
        int ipInt = ipv4ToInt(ip);
        if (ipInt < 0) {
            high.set(ipInt + Integer.MAX_VALUE + 1);
        } else {
            low.set(ipInt);
        }
        return true;
    }

    public static boolean isWhiteIpAddress(String ip) {
        int ipInt = ipv4ToInt(ip);
        if (ipInt < 0) {
            return high.get(ipInt + Integer.MAX_VALUE + 1);
        } else {
            return low.get(ipInt);
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(2));
        System.out.println(Integer.toBinaryString(127));
        System.out.println(Integer.toBinaryString(255));
        System.out.println(getLength8BinaryString(1));
        System.out.println(getLength8BinaryString(127));

        String ip1 = "0.0.0.0";
        addWhiteIpAddress(ip1);
        assert isWhiteIpAddress(ip1);

        String ip2 = "127.0.0.1";
        addWhiteIpAddress(ip2);
        assert isWhiteIpAddress(ip2);

        String ip3 = "255.255.255.255";
        addWhiteIpAddress(ip3);
        assert isWhiteIpAddress(ip3);

        String ip4 = "128.0.0.0";
        addWhiteIpAddress(ip4);
        assert isWhiteIpAddress(ip4);

        assert !isWhiteIpAddress("0.0.0.1");
        assert !isWhiteIpAddress("1.1.1.1");
        assert !isWhiteIpAddress("001.001.001.001");
    }
}
