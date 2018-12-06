import _59frames.Ds._59utils.validation.Validator;

import static _59frames.Ds._59utils.PromptHandler.print;

public class Test {
    public static void main(String[] args) {
        String ipv4_false = "1.1.1";
        String ipv4_true = "92.107.212.34";

        String ipv6_false = "2a02:1205:c6bd:4220:cc93:5e5a:2a87:f4fx";
        String ipv6_true = "2a02:1205:c6bd:4220:cc93:5e5a:2a87:f4fe";

        print(Validator.isIpv4(ipv4_false));
        print(Validator.isIpv4(ipv4_true));

        print(Validator.isIpv6(ipv6_false));
        print(Validator.isIpv6(ipv6_true));

    }
}
