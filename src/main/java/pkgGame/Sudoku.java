package pkgGame;

import java.util.ArrayList;

import pkgHelper.LatinSquare;

public class Sudoku extends LatinSquare {
	
	private int iSize;
	private int iSqrtSize;
	
	public Sudoku(int iSize) throws Exception {
		super();
		this.iSize = iSize;
		if(Math.sqrt(this.iSize) == Math.ceil(Math.sqrt(this.iSize))) {
			this.iSqrtSize = (int)Math.sqrt(this.iSize);
		} else {
			throw new Exception("Size is not a perfect square. Square root must be an integer");
		}
	}
	
	public Sudoku(int[][] puzzle) throws Exception {
		this.iSize = puzzle.length;
		if(Math.sqrt(this.iSize) == Math.ceil(Math.sqrt(this.iSize))) {
			this.iSqrtSize = (int)Math.sqrt(this.iSize);
		} else {
			throw new Exception("Size is not a perfect square. Square root must be an integer");
		}
	}
	
	protected int[][] getPuzzle(){
		return super.getLatinSquare();
	}
	
	public int[] getRegion(int iCol, int iRow) {
		int row = (iRow % iSqrtSize) * iSqrtSize;
		int col = (iCol / iSqrtSize) * iSqrtSize;
		return this.getRegion(row+col);
	}
	
	public int[] getRegion(int r) {
		int i = (r % iSqrtSize) * iSqrtSize;
		int j = (r / iSqrtSize) * iSqrtSize;
		int iMax = i + iSqrtSize;
		int jMax = j + iSqrtSize;
		int[] vals = new int[9];
		int cnt = 0;
		for(; i < iMax; i++) {
			for(; j < jMax; j++) {
				vals[cnt] = super.getLatinSquare()[i][j];
				cnt++;
			}
		}
		return vals;
	}
	
	protected boolean isSudoku(){
		if (!super.isLatinSquare()){
			return false;
		}
		for(int i = 0; i < iSize; i++) {
			int[] currentArray = this.getRegion(i);
			if(hasDuplicates(RemoveZeros(currentArray))) {
				return false;
			}
		}
		return true;
	}
	
	protected boolean isPartialSudoku() {
		
		return false;
	}
	
	public boolean isValidValue​(int iCol, int iRow, int iValue) {
		
		
		
		return true;
	}
}
