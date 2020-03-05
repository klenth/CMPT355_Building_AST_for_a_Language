package cmpt355.example.hinky.util;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * A class providing utility methods related to tree traversal.
 */
public final class Trees {

    // Cannot instantiate
    private Trees() { }

    /**
     * Performs a depth-first pre-order traversal of the tree with the given root, applying f to each tree node
     * (starting with root).
     * @param root     the root of the tree
     * @param childMap a function mapping a tree node to the children of that node (in an {@link Iterable})
     * @param f        the operation to apply to each tree node
     * @param <Node>   the data type of tree nodes
     */
    public static <Node> void preOrder(Node root,
                                       Function<? super Node, ? extends Iterable<? extends Node>> childMap,
                                       Consumer<? super Node> f) {
        f.accept(root);
        childMap.apply(root).forEach(child -> Trees.preOrder(child, childMap, f));
    }

    /**
     * Returns a {@link Stream} of the nodes in this tree in a depth-first pre-order traversal, starting with the root.
     * @param root     the root of the tree
     * @param childMap a function mapping a tree node to the children of that node (an {@link Iterable})
     * @param <Node>   the data type of tree nodes
     */
    public static <Node> Stream<Node> preOrder(Node root,
                                               Function<? super Node, ? extends Iterable<? extends Node>> childMap) {
        return StreamSupport.stream(new Spliterators.AbstractSpliterator<>(
                Long.MAX_VALUE,
                Spliterator.DISTINCT | Spliterator.NONNULL | Spliterator.ORDERED
        ) {
            private Deque<Iterator<? extends Node>> stack = new ArrayDeque<>();

            { stack.push(List.of(root).iterator()); }

            @Override
            public boolean tryAdvance(Consumer<? super Node> action) {
                while (!stack.isEmpty()) {
                    if (stack.peek().hasNext()) {
                        var node = stack.peek().next();
                        stack.push(childMap.apply(node).iterator());
                        action.accept(node);
                        return true;
                    } else
                        stack.pop();
                }
                return false;
            }
        }, false);
    }

    /**
     * Performs a depth-first post-order traversal of the tree with the given root, applying f to each tree node
     * (finishing with root).
     * @param root     the root of the tree
     * @param childMap a function mapping a tree node to the children of that node (in an {@link Iterable})
     * @param f        the operation to apply to each tree node
     * @param <Node>   the data type of tree nodes
     */
    public static <Node> void postOrder(Node root,
                                        Function<? super Node, ? extends Iterable<? extends Node>> childMap,
                                        Consumer<? super Node> f) {
        childMap.apply(root).forEach(child -> Trees.postOrder(child, childMap, f));
        f.accept(root);
    }

    /**
     * Returns a {@link Stream} of the nodes in this tree in a depth-first post-order traversal, finishing with the root.
     * @param root     the root of the tree
     * @param childMap a function mapping a tree node to the children of that node (an {@link Iterable})
     * @param <Node>   the data type of tree nodes
     */
    public static <Node> Stream<Node> postOrder(Node root,
                                                Function<? super Node, ? extends Iterable<? extends Node>> childMap) {
        return StreamSupport.stream(new Spliterators.AbstractSpliterator<>(
                Long.MAX_VALUE,
                Spliterator.DISTINCT | Spliterator.NONNULL | Spliterator.ORDERED
        ) {
            private Deque<Node> parentStack = new ArrayDeque<>();
            private Deque<Iterator<? extends Node>> stack = new ArrayDeque<>();

            {
                parentStack.push(root);
                stack.push(childMap.apply(root).iterator());
            }

            @Override
            public boolean tryAdvance(Consumer<? super Node> action) {
                while (!stack.isEmpty()) {
                    if (stack.peek().hasNext()) {
                        var node = stack.peek().next();
                        parentStack.push(node);
                        stack.push(childMap.apply(node).iterator());
                    } else {
                        stack.pop();
                        action.accept(parentStack.pop());
                        return true;
                    }
                }
                return false;
            }
        }, false);

    }
}
