import java.util.HashSet;
import java.util.Set;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

class LoopChecker {

    private boolean useHashMap = false;

    boolean hasLoop(IListElement first) {
        if (isNull(first)) {
            return false;
        }

        return useHashMap ? checkWithHashMap(first) : checkWithTwoStepIteration(first);
    }

    private boolean checkWithTwoStepIteration(IListElement first) {
        IListElement next = first.getNext();

        if(isNull(next)){
            return false;
        }

        IListElement twoStep = next.getNext();
        if(isNull(twoStep)){
            return false;
        }

        while(nonNull(next)){
            if(twoStep.equals(next)){
                return true;
            }

            IListElement oneAfterTwoStep = twoStep.getNext();
            if(isNull(oneAfterTwoStep)){
                return false;
            }

            IListElement twoAfterTwoStep = oneAfterTwoStep.getNext();
            if(isNull(twoAfterTwoStep)){
                return false;
            }

            twoStep = twoAfterTwoStep;

            next = next.getNext();
        }

        return false;
    }

    private boolean checkWithHashMap(IListElement first){
        Set<IListElement> knownElements = new HashSet<>();
        knownElements.add(first);

        IListElement current = first.getNext();
        while (nonNull(current)) {
            if (!knownElements.add(current)) {
                return false;
            }

            current = current.getNext();
        }

        return true;
    }
}
