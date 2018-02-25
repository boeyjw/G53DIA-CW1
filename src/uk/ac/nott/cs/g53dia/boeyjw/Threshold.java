package uk.ac.nott.cs.g53dia.boeyjw;

import uk.ac.nott.cs.g53dia.library.Tanker;

/**
 * Creates thresholds for any actions/items that has some sort of absolute value associated with it
 */
public enum Threshold {
    LOWEST_FUEL((int) Math.floor(Tanker.MAX_FUEL * 0.5) + 2, false),
    HIGHEST_WASTE((int) Math.floor(Tanker.MAX_WASTE * 0.9), true),
    TOTAL_VIEW_RANGE(Tanker.VIEW_RANGE * 2 + 1, false),
    TOTAL_DIRECTION_BOUND(8, true),
    REFUEL_ERROR_MARGIN(3, true);

    private final int thresh;
    private final boolean isUpperLimit;

    Threshold(int thresh, boolean isUpperLimit) {
        this.thresh = thresh;
        this.isUpperLimit = isUpperLimit;
    }

    int getThresh() {
        return thresh;
    }

    int getTotalViewGridLength() {
        return TOTAL_VIEW_RANGE.getThresh() * TOTAL_VIEW_RANGE.getThresh();
    }

    boolean hitThresh(int value) {
        return isUpperLimit ? value >= thresh : value <= thresh;
    }
}
