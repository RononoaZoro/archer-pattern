package com.luo.command.undo;


/**
 * 调光器
 *
 * @author luoxuzheng
 * @create 2019-09-15 21:56
 **/
public class DimmerLightOffCommand implements Command {
	Light light;
	int prevLevel;

	public DimmerLightOffCommand(Light light) {
		this.light = light;
		prevLevel = 100;
	}

	public void execute() {
		prevLevel = light.getLevel();
		light.off();
	}

	public void undo() {
		light.dim(prevLevel);
	}
}
