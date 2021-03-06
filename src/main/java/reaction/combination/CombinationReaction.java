package reaction.combination;

import reaction.Reaction;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * やり取りできるリアクション
 */
public abstract class CombinationReaction implements Reaction {

    private boolean doChain;
    protected Deque<ChainReaction> reactions = new ArrayDeque<>();

    protected CombinationReaction(List<ChainReaction> reactions) {
        reactions.forEach(this::add);
    }

    protected CombinationReaction(ChainReaction... reactions) {
        Arrays.asList(reactions).forEach(this::add);
    }

    public void add(ChainReaction chainReaction) {
        this.reactions.add(chainReaction);
    }

    public ChainReaction next() {
        return reactions.peekFirst();
    }

    public ChainReaction remove() {
        return reactions.removeFirst();
    }

    public boolean isDoChain() {
        return doChain;
    }

    public void setDoChain(boolean doChain) {
        this.doChain = doChain;
    }

    public boolean overMaxRetryCount() {
        return next().getMaxRetryCount() < next().getCurrentRetryCount();
    }

    public void incrementRetryCount() {
        ChainReaction c = reactions.removeFirst();
        c.setCurrentRetryCount(c.getCurrentRetryCount() + 1);
        reactions.addFirst(c);
    }

    public boolean isChainEmpty() {
        return reactions.isEmpty();
    }

}

