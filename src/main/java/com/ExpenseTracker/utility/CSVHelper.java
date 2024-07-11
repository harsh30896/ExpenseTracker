package com.ExpenseTracker.utility;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import com.ExpenseTracker.entity.ExpenseEntity;

public class CSVHelper {
	
	public static void writeExpensesToCsv(Writer writer,List<ExpenseEntity> expenses)throws IOException {
		try(CSVPrinter csvPrinter = new CSVPrinter(writer,CSVFormat.DEFAULT.withHeader("expenseId","private",
				"amount","category"))){
			for(ExpenseEntity expense:expenses) {
				csvPrinter.printRecord(expense.getExpenseId(),expense.getAmount(),expense.getCategory(),
						expense.getDate(),expense.getDescription());
			}
		}
	}

}
