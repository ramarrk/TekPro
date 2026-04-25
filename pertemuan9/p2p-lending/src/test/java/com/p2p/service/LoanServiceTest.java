package com.p2p.service;

import com.p2p.domain.Borrower;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import com.p2p.domain.Loan;

public class LoanServiceTest {

    @Test
    void shouldRejectLoanWhenBorrowerNotVerified() {
        // TC-01
        // =====================================================
        // SCENARIO:
        // Borrower tidak terverifikasi (KYC = false)
        // Ketika borrower mengajukan pinjaman
        // Maka sistem harus menolak dengan melempar exception
        // =====================================================

        // =========================
        // Arrange (Initial Condition)
        // =========================
        // Borrower belum lolos proses KYC
        Borrower borrower = new Borrower(false, 700);

        // Service untuk pengajuan loan
        LoanService loanService = new LoanService();

        // Jumlah pinjaman valid
        BigDecimal amount = BigDecimal.valueOf(1000);

        // =========================
        // ACTION + ASSERT (Act + Assert)
        // =========================
        // Ketika borrower mengajukan loan,
        // sistem harus MENOLAK dengan melempar exception
        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, amount);
        });
    }

    @Test
    void shouldRejectLoanWhenAmountIsZeroOrNegative() {
        // TC - 02
        // Arrange
        Borrower borrower = new Borrower(true, 700); // borrower valid
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.ZERO; // amount tidak valid

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, amount);
        });
    }


    @Test
    void shouldApproveLoanWhenCreditScoreHigh() {
        // TC - 03
        // Arrange
        Borrower borrower = new Borrower(true, 700); // credit score tinggi
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(1000);

        // Act
        Loan loan = loanService.createLoan(borrower, amount);

        // Assert
        assertEquals(Loan.Status.APPROVED, loan.getStatus());
    }

    @Test
    void shouldRejectLoanWhenCreditScoreLow() {
        //TC - 04
        // Arrange
        Borrower borrower = new Borrower(true, 500); // credit score rendah
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(1000);

        // Act
        Loan loan = loanService.createLoan(borrower, amount);

        // Assert
        assertEquals(Loan.Status.REJECTED, loan.getStatus());
    }
}