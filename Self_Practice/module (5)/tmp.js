for(var i in arr_a) {
    if(i === "block" + depth) {
        tmpCurrentArr = tmpCurrentArr.concat(arr_a[i]);    
    } else {
        tmpBeforeArr = tmpBeforeArr.concat(arr_a[i]);                    
    }
}

for(var i in tmpCurrentArr) {
    let currentElements = tmpCurrentArr[i].split(",");
    let N = Object.assign([],tmpBeforeArr);
    do {
        let M = Object.assign([],N);
        checkbox = [];
        for(var j in M) {            
            let tmpCnt = 0;
            for(var q in currentElements) {
                let findIdx = pDataset[M[j]].findIndex((row)=>{
                    return row === currentElements[q];
                });
        
                if(findIdx !== -1) {
                    tmpCnt++;
                }
            };
            
            let len = currentElements.length;
            if(tmpCnt === len) {
                for(var q=1;q<=len;q++) {
                    if(q === 1) {
                        for(var k=0;k<len-1;k++) {
                            N.splice(currentElements[k],1);
                        }
                    } else {                        
                        for(var k=0;k<len-1;k++) {
                            let tmp = [];
                            tmp.push(currentElements[k]);
                            for(var l=1; l<len; l++) {
                                for(var m=k+l;m<len;m++) { 
                                    tmp.push(currentElements[m]);
                                    let value = tmp.join() + "";    
                                    N.splice(value,1);                    
                                    if(tmp.length === q) {
                                        tmp.splice(tmp.length-1,1);    
                                    }
                                }
                                tmp.splice(l,(q-1));      
                            }                            
                        }
                    }
                }
            } else {
                tmpCnt = 0;
                let t_M = M[j].split(",");
                for(var q in currentElements) {
                    let findIdx = t_M.findIndex((row)=>{
                        return row === currentElements[q];
                    });
            
                    if(findIdx !== -1) {
                        tmpCnt++;
                    }
                };

                let len = currentElements.length;
                if(tmpCnt === len) {
                    currentElements = currentElements + "," + M[j];
                    currentElements = currentElements.split(",").sort();
                    N.splice(M[j],1);
                    checkbox.push(M[j]);
                }
            }
        }
        console.log(checkbox.length);
    } while (checkbox.length !== 0)

    for(var j in currentElements) {
        blocks[tmpCurrentArr[i]][currentElements[j]] = 1;
    }
}