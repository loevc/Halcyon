package org.loevc.halcyon.leetcode;

import java.lang.reflect.*;
import java.math.BigDecimal;
import java.util.*;

public class Q208 {

    class Trie {

        char val;
        List<Trie> list;

        public Trie() {
            this.val = ' ';
            this.list = new ArrayList<Trie>(26);
        }

        public void insert(String word) {
            if (word.length() == 0)
                return;
            char[] chars = word.toCharArray();
            List<Trie> list = this.list;
            boolean hasFound = false;
            for (char c : chars) {
                for (Trie t : list) {
                    if (t != null && t.val == c) {
                        list = t.list;
                        hasFound = true;
                        break;
                    }
                }
                if (hasFound) {
                    hasFound = false;
                    continue;
                }
                Trie t = new Trie();
                list.add(t);
                t.val = c;
                t.list = new ArrayList<>();
                list = t.list;
            }
            list.add(null);
        }

        public boolean search(String word) {
            if (word.length() == 0)
                return false;
            char[] chars = word.toCharArray();
            List<Trie> list = this.list;
            for (char c : chars) {
                boolean unfound = true;
                for (Trie t : list) {
                    if (t != null && t.val == c) {
                        list = t.list;
                        unfound = false;
                        break;
                    }
                }
                if (unfound) {
                    return false;
                }
            }
            if (list.contains(null))
                return true;
            return false;
        }

        public boolean startsWith(String prefix) {
            if (prefix.length() == 0)
                return false;
            char[] chars = prefix.toCharArray();
            List<Trie> list = this.list;

            for (char c : chars) {
                boolean unfound = true;
                for (Trie t : list) {
                    if (t != null && t.val == c) {
                        list = t.list;
                        unfound = false;
                        continue;
                    }
                }
                if (unfound) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */

    public static void main(String[] args) throws Exception {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        java.util.List<?> operations = asList(new Parser(scanner.nextLine()).parse());
        java.util.List<?> argumentGroups = asList(new Parser(scanner.nextLine()).parse());

        if (operations.isEmpty() || operations.size() != argumentGroups.size()) {
            throw new IllegalArgumentException("操作和参数必须是长度相同的非空数组");
        }

        String requestedName = (String) operations.get(0);
        Class<?> host = java.lang.invoke.MethodHandles.lookup().lookupClass();

        // 第一项可以是运行 main 的类名，也可以是它的成员类名。
        Class<?> target = null;
        if (host.getSimpleName().equals(requestedName)) {
            target = host;
        } else {
            for (Class<?> member : host.getDeclaredClasses()) {
                if (member.getSimpleName().equals(requestedName)) {
                    target = member;
                    break;
                }
            }
        }

        if (target == null) {
            throw new IllegalArgumentException(
                    "在 " + host.getName() + " 中找不到题目类 " + requestedName
            );
        }

        // 非 static 成员类的构造器有一个额外的外部实例参数。
        boolean needsOuter = target.isMemberClass()
                && !java.lang.reflect.Modifier.isStatic(target.getModifiers());
        int offset = needsOuter ? 1 : 0;
        java.util.List<?> values = asList(argumentGroups.get(0));

        java.lang.reflect.Constructor<?> constructor = null;
        Object[] constructorArgs = null;

        for (java.lang.reflect.Constructor<?> candidate : target.getDeclaredConstructors()) {
            if (candidate.getParameterCount() != values.size() + offset) {
                continue;
            }

            java.lang.reflect.Type[] types = candidate.getGenericParameterTypes();
            // 泛型参数列表可能省略编译器添加的外部实例参数。
            int typeOffset = types.length == candidate.getParameterCount() ? offset : 0;
            Object[] converted = new Object[candidate.getParameterCount()];

            try {
                for (int i = 0; i < values.size(); i++) {
                    converted[i + offset] = convert(values.get(i), types[i + typeOffset]);
                }
            } catch (IllegalArgumentException | ArithmeticException e) {
                continue;
            }

            if (constructor != null) {
                throw new IllegalArgumentException("存在多个匹配的构造器 " + requestedName);
            }
            constructor = candidate;
            constructorArgs = converted;
        }

        if (constructor == null) {
            throw new IllegalArgumentException(
                    "找不到匹配的构造器 " + requestedName + "，参数 " + values
            );
        }

        if (needsOuter) {
            Class<?> outer = target.getDeclaringClass();
            java.lang.reflect.Constructor<?> outerConstructor;
            try {
                outerConstructor = outer.getDeclaredConstructor();
            } catch (NoSuchMethodException e) {
                throw new IllegalArgumentException(
                        "自动创建外部实例需要无参构造器 " + outer.getName(), e
                );
            }
            outerConstructor.setAccessible(true);
            constructorArgs[0] = outerConstructor.newInstance();
        }

        constructor.setAccessible(true);
        Object instance = constructor.newInstance(constructorArgs);

        java.util.StringJoiner output = new java.util.StringJoiner(",", "[", "]");
        output.add("null");

        for (int i = 1; i < operations.size(); i++) {
            String name = (String) operations.get(i);
            java.util.List<java.lang.reflect.Method> candidates = new java.util.ArrayList<>();

            for (java.lang.reflect.Method method : target.getMethods()) {
                if (method.getName().equals(name)
                        && method.getDeclaringClass() != Object.class
                        && !java.lang.reflect.Modifier.isStatic(method.getModifiers())
                        && !method.isBridge()
                        && !method.isSynthetic()) {
                    candidates.add(method);
                }
            }

            Call<java.lang.reflect.Method> call =
                    resolve(name, candidates, asList(argumentGroups.get(i)));
            call.member.setAccessible(true);

            try {
                output.add(format(call.member.invoke(instance, call.arguments)));
            } catch (java.lang.reflect.InvocationTargetException e) {
                throw new IllegalStateException(
                        "第 " + (i + 1) + " 项操作失败 " + name, e.getCause()
                );
            }
        }

        System.out.println(output);
    }

    private static <T extends Executable> Call<T> resolve(
            String name, List<T> candidates, List<?> values) {
        Call<T> match = null;

        for (T candidate : candidates) {
            Type[] types = candidate.getGenericParameterTypes();
            if (types.length != values.size()) {
                continue;
            }

            Object[] arguments = new Object[types.length];
            try {
                for (int i = 0; i < types.length; i++) {
                    arguments[i] = convert(values.get(i), types[i]);
                }
            } catch (IllegalArgumentException | ArithmeticException e) {
                continue;
            }

            if (match != null) {
                throw new IllegalArgumentException("存在多个匹配的重载 " + name + " " + values);
            }
            match = new Call<>(candidate, arguments);
        }

        if (match == null) {
            throw new IllegalArgumentException("找不到匹配的构造器或方法 " + name + " " + values);
        }
        return match;
    }

    private static Object convert(Object value, Type type) {
        if (value == null) {
            if (type instanceof Class<?> && ((Class<?>) type).isPrimitive()) {
                throw new IllegalArgumentException("基本类型不能接收 null");
            }
            return null;
        }

        if (type instanceof ParameterizedType) {
            ParameterizedType generic = (ParameterizedType) type;
            if (generic.getRawType() == List.class) {
                Type elementType = generic.getActualTypeArguments()[0];
                List<Object> result = new ArrayList<>();
                for (Object element : asList(value)) {
                    result.add(convert(element, elementType));
                }
                return result;
            }
        }

        if (type instanceof Class<?>) {
            Class<?> target = (Class<?>) type;

            if (target.isArray()) {
                List<?> elements = asList(value);
                Class<?> component = target.getComponentType();
                Object array = Array.newInstance(component, elements.size());
                for (int i = 0; i < elements.size(); i++) {
                    Array.set(array, i, convert(elements.get(i), component));
                }
                return array;
            }

            if (target.isInstance(value)) return value;
            if (target == boolean.class && value instanceof Boolean) return value;

            if ((target == char.class || target == Character.class)
                    && value instanceof String && ((String) value).length() == 1) {
                return ((String) value).charAt(0);
            }

            if (value instanceof BigDecimal) {
                BigDecimal number = (BigDecimal) value;
                if (target == int.class || target == Integer.class) return number.intValueExact();
                if (target == long.class || target == Long.class) return number.longValueExact();
                if (target == short.class || target == Short.class) return number.shortValueExact();
                if (target == byte.class || target == Byte.class) return number.byteValueExact();
                if (target == double.class || target == Double.class) return number.doubleValue();
                if (target == float.class || target == Float.class) return number.floatValue();
            }
        }

        throw new IllegalArgumentException("参数无法转换为 " + type.getTypeName());
    }

    private static List<?> asList(Object value) {
        if (!(value instanceof List<?>)) {
            throw new IllegalArgumentException("预期输入数组");
        }
        return (List<?>) value;
    }

    private static String format(Object value) {
        if (value == null || value instanceof Number || value instanceof Boolean) {
            return String.valueOf(value);
        }

        if (value.getClass().isArray()) {
            StringJoiner result = new StringJoiner(",", "[", "]");
            for (int i = 0; i < Array.getLength(value); i++) {
                result.add(format(Array.get(value, i)));
            }
            return result.toString();
        }

        if (value instanceof Iterable<?>) {
            StringJoiner result = new StringJoiner(",", "[", "]");
            for (Object element : (Iterable<?>) value) {
                result.add(format(element));
            }
            return result.toString();
        }

        if (value instanceof String || value instanceof Character) {
            StringBuilder result = new StringBuilder("\"");
            for (char c : value.toString().toCharArray()) {
                if (c == '"' || c == '\\') {
                    result.append('\\').append(c);
                } else if (c < ' ') {
                    result.append(String.format("\\u%04x", (int) c));
                } else {
                    result.append(c);
                }
            }
            return result.append('"').toString();
        }

        throw new IllegalArgumentException("不支持输出类型 " + value.getClass().getName());
    }

    private static final class Call<T extends Executable> {
        final T member;
        final Object[] arguments;

        Call(T member, Object[] arguments) {
            this.member = member;
            this.arguments = arguments;
        }
    }

    private static final class Parser {
        private final String text;
        private int pos;

        Parser(String text) {
            this.text = text;
        }

        Object parse() {
            Object result = readValue();
            skipWhitespace();
            if (pos != text.length()) throw invalidInput();
            return result;
        }

        private Object readValue() {
            skipWhitespace();
            if (pos == text.length()) throw invalidInput();

            char c = text.charAt(pos);
            if (c == '[') return readArray();
            if (c == '"') return readString();
            if (consume("true")) return true;
            if (consume("false")) return false;
            if (consume("null")) return null;

            int start = pos;
            while (pos < text.length()
                    && "0123456789-+.eE".indexOf(text.charAt(pos)) >= 0) {
                pos++;
            }
            if (start == pos) throw invalidInput();
            try {
                return new BigDecimal(text.substring(start, pos));
            } catch (NumberFormatException e) {
                throw invalidInput();
            }
        }

        private List<Object> readArray() {
            pos++;
            List<Object> result = new ArrayList<>();
            skipWhitespace();
            if (consume("]")) return result;

            do {
                result.add(readValue());
                skipWhitespace();
            } while (consume(","));

            if (!consume("]")) throw invalidInput();
            return result;
        }

        private String readString() {
            pos++;
            StringBuilder result = new StringBuilder();

            while (pos < text.length()) {
                char c = text.charAt(pos++);
                if (c == '"') return result.toString();
                if (c < ' ') throw invalidInput();
                result.append(c == '\\' ? readEscape() : c);
            }
            throw invalidInput();
        }

        private char readEscape() {
            if (pos == text.length()) throw invalidInput();
            char c = text.charAt(pos++);

            switch (c) {
                case '"': case '\\': case '/': return c;
                case 'b': return '\b';
                case 'f': return '\f';
                case 'n': return '\n';
                case 'r': return '\r';
                case 't': return '\t';
                case 'u':
                    if (text.length() - pos < 4) throw invalidInput();
                    int code = 0;
                    for (int i = 0; i < 4; i++) {
                        int digit = Character.digit(text.charAt(pos++), 16);
                        if (digit < 0) throw invalidInput();
                        code = code * 16 + digit;
                    }
                    return (char) code;
                default:
                    throw invalidInput();
            }
        }

        private boolean consume(String token) {
            if (!text.startsWith(token, pos)) return false;
            pos += token.length();
            return true;
        }

        private void skipWhitespace() {
            while (pos < text.length() && Character.isWhitespace(text.charAt(pos))) {
                pos++;
            }
        }

        private IllegalArgumentException invalidInput() {
            return new IllegalArgumentException("输入格式错误，位置 " + (pos + 1));
        }
    }
}
