package com.locker.be.web.user.util;

import java.util.concurrent.ThreadLocalRandom;

public class NicknameGenerator {

    private static final String[] PREFIXES = {
            "여명속", "노을빛", "달빛아래", "은하를걷는", "바람결의",
            "고요한", "반짝이는", "포근한", "빛나는", "잔잔한"
    };

    private static final String[] MIDDLES = {
            "도약하는", "달리는", "춤추는", "노래하는", "헤엄치는",
            "비상하는", "숨쉬는", "잠든", "산책하는", "기다리는"
    };

    private static final String[] SUFFIXES = {
            "대게", "참새", "다람쥐", "고양이", "여우",
            "토끼", "수달", "판다", "고래", "펭귄"
    };

    public static String generate() {
        String prefix = PREFIXES[randomIndex(PREFIXES.length)];
        String middle = MIDDLES[randomIndex(MIDDLES.length)];
        String suffix = SUFFIXES[randomIndex(SUFFIXES.length)];
        return prefix + middle + suffix;
    }

    public static String generateWithNumber() {
        int number = ThreadLocalRandom.current().nextInt(100, 1000);
        return generate() + number;
    }

    private static int randomIndex(int bound) {
        return ThreadLocalRandom.current().nextInt(bound);
    }
}