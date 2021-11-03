package offer20;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CJR
 * @create 2021-10-30-19:11
 */

/*
剑指 Offer 20. 表示数值的字符串
请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。

数值（按顺序）可以分成以下几个部分：

若干空格
一个 小数 或者 整数
（可选）一个 'e' 或 'E' ，后面跟着一个 整数
若干空格
小数（按顺序）可以分成以下几个部分：

（可选）一个符号字符（'+' 或 '-'）
下述格式之一：
至少一位数字，后面跟着一个点 '.'
至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
一个点 '.' ，后面跟着至少一位数字
整数（按顺序）可以分成以下几个部分：

（可选）一个符号字符（'+' 或 '-'）
至少一位数字
 */


// 有限状态机
class Solution {
    public boolean isNumber(String s) {
         Map<State,Map<CharType,State>> transfer = new HashMap<State,Map<CharType,State>>();
         Map<CharType,State> initialMap = new HashMap<CharType,State>() {{
             put(CharType.CHAR_SPACE,State.STATE_INITIAL);
             put(CharType.CHAR_NUMBER,State.STATE_INTEGER);
             put(CharType.CHAR_POINT,State.STATE_POINT_WITHOUT_INT);
             put(CharType.CHAR_SIGN,State.STATE_INIT_SIGN);
         }};
         transfer.put(State.STATE_INITIAL,initialMap);
         Map<CharType,State> intSignMap = new HashMap<CharType,State>() {{
            put(CharType.CHAR_NUMBER,State.STATE_INTEGER);
            put(CharType.CHAR_POINT,State.STATE_POINT_WITHOUT_INT);
         }};
         transfer.put(State.STATE_INIT_SIGN,intSignMap);
         Map<CharType,State> integerMap = new HashMap<CharType,State>(){{
             put(CharType.CHAR_NUMBER,State.STATE_INTEGER);
             put(CharType.CHAR_SPACE,State.STATE_END);
             put(CharType.CHAR_POINT,State.STATE_POINT);
             put(CharType.CHAR_EXP,State.STATE_EXP);
         }};
         transfer.put(State.STATE_INTEGER,integerMap);
         Map<CharType,State> pointMap = new HashMap<CharType,State>() {{
            put(CharType.CHAR_SPACE,State.STATE_END);
            put(CharType.CHAR_NUMBER,State.STATE_FRACTION);
            put(CharType.CHAR_EXP,State.STATE_EXP);
         }};
         transfer.put(State.STATE_POINT,pointMap);
         Map<CharType,State> pointWithoutIntMap = new HashMap<CharType,State>(){{
             put(CharType.CHAR_NUMBER,State.STATE_FRACTION);
         }};
         transfer.put(State.STATE_POINT_WITHOUT_INT,pointWithoutIntMap);
         Map<CharType,State> fractionMap = new HashMap<CharType,State>(){{
            put(CharType.CHAR_NUMBER,State.STATE_FRACTION);
            put(CharType.CHAR_SPACE,State.STATE_END);
            put(CharType.CHAR_EXP,State.STATE_EXP);
         }};
         transfer.put(State.STATE_FRACTION,fractionMap);
         Map<CharType,State> expMap = new HashMap<CharType,State>(){{
            put(CharType.CHAR_SIGN,State.STAET_EXP_SIGN);
            put(CharType.CHAR_NUMBER,State.STATE_EXP_NUMBER);
         }};
         transfer.put(State.STATE_EXP,expMap);
         Map<CharType,State> expSignMap = new HashMap<CharType,State>(){{
            put(CharType.CHAR_NUMBER,State.STATE_EXP_NUMBER);
         }};
         transfer.put(State.STAET_EXP_SIGN,expSignMap);
         Map<CharType,State> expNumberMap = new HashMap<CharType,State>(){{
            put(CharType.CHAR_NUMBER,State.STATE_EXP_NUMBER);
            put(CharType.CHAR_SPACE,State.STATE_END);
         }};
         transfer.put(State.STATE_EXP_NUMBER,expNumberMap);
         Map<CharType,State> endMap = new HashMap<CharType, State>(){{
            put(CharType.CHAR_SPACE,State.STATE_END);
         }};
         transfer.put(State.STATE_END,endMap);

         int length = s.length();
         State state = State.STATE_INITIAL;

        for (int i = 0; i < length; i++) {
            CharType type = toCharType(s.charAt(i));
            if (!transfer.get(state).containsKey(type)) {
                return false;
            } else {
                state = transfer.get(state).get(type);
            }
        }
        return state == State.STATE_INTEGER
                || state == State.STATE_POINT
                || state == State.STATE_FRACTION
                || state == State.STATE_EXP_NUMBER
                || state == State.STATE_END;
    }

    public CharType toCharType(char ch) {
        if (ch >= '0' && ch <= '9') {
            return CharType.CHAR_NUMBER;
        } else if (ch == 'e' || ch == 'E') {
            return CharType.CHAR_EXP;
        } else if (ch == '.') {
            return CharType.CHAR_POINT;
        } else if (ch == '+' || ch == '-') {
            return CharType.CHAR_SIGN;
        } else if (ch == ' ') {
            return CharType.CHAR_SPACE;
        } else {
            return CharType.CHAR_ILLEGAL;
        }
    }

    enum State {
        STATE_INITIAL,
        STATE_INIT_SIGN,
        STATE_INTEGER,
        STATE_POINT,
        STATE_POINT_WITHOUT_INT,
        STATE_FRACTION,
        STATE_EXP,
        STAET_EXP_SIGN,
        STATE_EXP_NUMBER,
        STATE_END
    }

    enum CharType {
        CHAR_NUMBER,
        CHAR_EXP,
        CHAR_POINT,
        CHAR_SIGN,
        CHAR_SPACE,
        CHAR_ILLEGAL
    }
}