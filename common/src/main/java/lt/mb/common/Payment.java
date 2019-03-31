package lt.mb.common;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Payment {

    @Id
    @GeneratedValue
    private long paymentId;
    private long personId;
    private BigDecimal amount;
    private LocalDate date;

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getPaymentId() {
        return paymentId;
    }

    public long getPersonId() {
        return personId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}


