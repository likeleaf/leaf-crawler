package com.oneflyingleaf.core.page;

import com.oneflyingleaf.core.html.Html;
import com.oneflyingleaf.core.pipeline.Pipeline;
import com.oneflyingleaf.core.util.CommonUtils;

public abstract class AbstractPage implements Page {
	
	/**已使用的pipeline的数量*/
	private int pipelineUsed = 0;
	
	protected Object[] pipeline = null;
	
	private final int pipelineIncrease = 5;

	public abstract Page execute(Html html);

	public Page addPipeline(Pipeline... pipelines) {
		pipeline = new Object[5];
		
		if(!CommonUtils.isEmpty(pipelines)){
			for(Pipeline p : pipelines){
				//空值不保存
				if(p == null ) continue ; 
				
				if(pipelineUsed > pipeline.length){
					Object[] pipelineTemp = new Object[pipelines.length+pipelineIncrease];
					
					System.arraycopy(pipeline, 0, pipelineTemp, 0, pipeline.length);
					
					pipeline =  pipelineTemp;
				}
				
				this.pipeline[pipelineUsed] = p;
				pipelineUsed ++ ;
			}
		}
		return this;
	}

	public Page removePipeline(Pipeline... pipelines) {
		int tempUsed = pipelineUsed;
		//数量不会多，直接两次循环   
		//删除
		for(Pipeline p : pipelines){
			for(int i = 0; i< tempUsed ; i++){
				if(this.pipeline[i] != null){
					if(p == this.pipeline[i]){
						this.pipeline[i] = null;
						pipelineUsed --;
					}
				}
			}
		}
		
		Object []temp = new Object[pipelineUsed];
		tempUsed = 0; 
		
		//重置次数
		for(int i = 0;i<pipeline.length;i++){
			if(pipeline[i] != null){
				temp[tempUsed] = pipeline[i];
				tempUsed ++;
			}
		}
		
		return this;
	}

	public Page save() {
		return this;
	}

}