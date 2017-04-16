package nl.gremmee.antopoly.statistics.impl;

import java.math.BigDecimal;

public class CollectorPojo implements Comparable<CollectorPojo> {
    private Integer totalCount;
    private Integer count;

    public CollectorPojo() {
        this.setCount(Integer.valueOf(1));
        this.setTotalCount(Integer.valueOf(1));
    }

    public Integer increaseCount() {
        return this.count++;
    }

    public Integer getCount() {
        return this.count;
    }

    private void setCount(final Integer aCount) {
        this.count = aCount;
    }

    public Integer getTotalCount() {
        return this.totalCount;
    }

    private void setTotalCount(final Integer aTotalCount) {
        this.totalCount = aTotalCount;
    }

    public Integer increaseTotalCount() {
        return this.totalCount++;
    }

    public BigDecimal getPercentage() {
        BigDecimal dividend = BigDecimal.valueOf(this.count).multiply(BigDecimal.TEN).multiply(BigDecimal.TEN);
        BigDecimal divisor = BigDecimal.valueOf(this.getTotalCount());
        return dividend.divide(divisor, 2, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public int compareTo(CollectorPojo aOther) {

        return this.getCount().compareTo(aOther.getCount());
    }

    @Override
    public String toString() {
        return this.count.toString() + "/" + this.totalCount.toString() + "==" + this.getPercentage().toString() + "%";
    }
}
