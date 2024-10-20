import java.util.ArrayList;

public class AccountStack<T> {
    private ArrayList<T> stack;

    public AccountStack() {
        stack = new ArrayList<>();
    }

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        if (!stack.isEmpty()) {
            return stack.remove(stack.size() - 1);
        }
        return null;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public ArrayList<T> getStack() {
        return stack;
    }
}