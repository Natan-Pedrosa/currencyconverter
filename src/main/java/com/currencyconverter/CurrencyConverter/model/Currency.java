package com.currencyconverter.CurrencyConverter.model;

public class Currency {

    String from;

    String to;

    double value;

    double valueFrom;

    double valueTo;

    public Currency(String from, String to) {
        this.from = from;
        this.to = to;
    }
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getValueTo() {
        return valueTo;
    }

    public void setValueFrom(double valueFrom) {
        this.valueFrom = valueFrom;
    }
    public void setValueTo(double value, double valueFrom) {
        this.valueTo = value * valueFrom;
    }

    public double getValueFrom() {
        return valueFrom;
    }

    @Override
    public String toString() {
        return "To:" +getTo() + "|" + "value:" + getValue();
    }
}
