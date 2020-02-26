
public class Blocks {
	// instance variables
	private int xSizeBlock; // pretty much Width of Block
	private int ySizeBlock; // Height of Block
	private double xLocationBlock; // x-Axis Location of certain Block
	private double yLocationBlock; // y-Axis Location of certain Block
	private String blockName = "Sample";
	
					// GETTERS
					
	public int getxSizeBlock() { //get Width of Block
		return xSizeBlock;
	}
	
	public int getySizeBlock() { // gets Height of Block
		return ySizeBlock;
	}
	
	public double getxLocationBlock() { // gets X Coordinate of Block
		return xLocationBlock;
	}
	
	public double getyLocationBlock() { // gets Y Coordinate of Block
		return yLocationBlock;
	}
	
	public String getBlockName() { // gets Block name (whether it's a wall, ground etc. not sure if will be used)
		return blockName;
	}
	
						// SETTERS
	
	public void setxSizeBlock(int xSizeBlock) { // Sets Width of Block depending on size of sprite or size of block in-game
		this.xSizeBlock = xSizeBlock;
	}
	
	public void setySizeBlock(int ySizeBlock) { // Sets Height of Block depending on size of sprite or size of block in-game
		this.ySizeBlock = ySizeBlock;
	}
	
	public void setxLocationBlock(double xLocationBlock) { // Sets X Location of Block Depending on Level Design
		this.xLocationBlock = xLocationBlock;
	}
	
	public void setyLocationBlock(double yLocationBlock) { // Sets Y location of Block depending on Level Design
		this.yLocationBlock = yLocationBlock;
	}
	
	public void setBlockName(String blockName) { // Sets Block name (will be implemented later to differentiate between each kind of block)
		this.blockName = blockName;
	}
	

}




	
	
