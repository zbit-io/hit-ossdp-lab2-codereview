import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

/**
 * 测试用例设计原则：
 * 1. **等价类划分**：将输入字符串分为有效和无效两大类，并进一步细分：
 *    - 有效等价类：
 *      a. 字符串长度在 4 到 12 之间。
 *      b. 生成的 IP 地址段数和长度符合标准（1-255，每段不含前导 0）。
 *    - 无效等价类：
 *      a. 字符串长度小于 4 或大于 12。
 *      b. 字符串包含非数字字符。
 * 2. **边界值分析**：
 *    - 输入字符串长度接近边界值（4 和 12）。
 *    - 数字段值在有效范围的边界值（0 和 255）。
 * 3. **特殊值测试**：
 *    - 字符串全为零（"0000"）。
 *    - 字符串长度正好等于 4，且每位数字相同（如 "1111"）。
 */

public class L2023120255_14_Test {

    /**
     * 测试方法：testValidInput
     * 测试目的：验证函数在有效输入下的正确性。
     * 用到的测试用例：
     * - "25525511135": 生成多个 IP 地址。
     * - "0000": 只生成一种 IP 地址。
     * - "101023": 生成多种 IP 地址。
     */
    @Test
    public void testValidInput() {
        Solution14 solution = new Solution14();

        // 测试用例 1
        List<String> result1 = solution.restoreIpAddresses("25525511135");
        assertEquals(List.of("255.255.11.135", "255.255.111.35"), result1);

        // 测试用例 2
        List<String> result2 = solution.restoreIpAddresses("0000");
        assertEquals(List.of("0.0.0.0"), result2);

        // 测试用例 3
        List<String> result3 = solution.restoreIpAddresses("101023");
        assertEquals(List.of(
            "1.0.10.23", "1.0.102.3",
            "10.1.0.23", "10.10.2.3",
            "101.0.2.3"
        ), result3);
    }

    /**
     * 测试方法：testInvalidInput
     * 测试目的：验证函数在无效输入下的行为。
     * 用到的测试用例：
     * - "": 空字符串。
     * - "123": 长度不足 4。
     * - "256256256256": 数字超出范围。
     * - "1234567890123": 长度超过 12。
     * - "abcde": 非数字字符。
     */
    @Test
    public void testInvalidInput() {
        Solution14 solution = new Solution14();

        // 测试用例 1
        List<String> result1 = solution.restoreIpAddresses("");
        assertTrue(result1.isEmpty());

        // 测试用例 2
        List<String> result2 = solution.restoreIpAddresses("123");
        assertTrue(result2.isEmpty());

        // 测试用例 3
        List<String> result3 = solution.restoreIpAddresses("256256256256");
        assertTrue(result3.isEmpty());

        // 测试用例 4
        List<String> result4 = solution.restoreIpAddresses("1234567890123");
        assertTrue(result4.isEmpty());

        // 测试用例 5
        List<String> result5 = solution.restoreIpAddresses("abcde");
        assertTrue(result5.isEmpty());
    }

    /**
     * 测试方法：testBoundaryCases
     * 测试目的：验证函数在边界值情况的正确性。
     * 用到的测试用例：
     * - "1111": 每位数字相同且正好 4 位。
     * - "123123123123": 长度正好为 12。
     * - "255255255255": 每段 IP 的最大有效值。
     */
    @Test
    public void testBoundaryCases() {
        Solution14 solution = new Solution14();

        // 测试用例 1
        List<String> result1 = solution.restoreIpAddresses("1111");
        assertEquals(List.of("1.1.1.1"), result1);

        // 测试用例 2
        List<String> result2 = solution.restoreIpAddresses("123123123123");
        assertEquals(List.of("123.123.123.123"), result2);

        // 测试用例 3
        List<String> result3 = solution.restoreIpAddresses("255255255255");
        assertEquals(List.of("255.255.255.255"), result3);
    }
}
