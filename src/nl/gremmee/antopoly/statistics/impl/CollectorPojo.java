package nl.gremmee.antopoly.statistics.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CollectorPojo implements Comparable {
    private Integer totalCount;
    private Integer count;
    private BigDecimal percentage;

    public CollectorPojo() {
        this.setCount(Integer.valueOf(1));
        this.setTotalCount(Integer.valueOf(1));
        this.setPercentage(BigDecimal.ZERO.setScale(4, RoundingMode.UP));
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

    private void setPercentage(final BigDecimal aPercentage) {
        this.percentage = aPercentage;
    }

    @Override
    public int compareTo(Object aOther) {

        CollectorPojo other = (CollectorPojo) aOther;
        return this.getCount().compareTo(other.getCount());
    }

    @Override
    public String toString() {
        return this.getCount().toString() + "/" + this.getTotalCount().toString() + "=="
                + this.getPercentage().toString();
    }
}
