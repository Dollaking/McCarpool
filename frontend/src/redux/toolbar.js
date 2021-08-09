import { createSlice } from "@reduxjs/toolkit";

export const toolbarSlice = createSlice({
   name: "toolbar",
   initialState: {
       sessionLength: sessionStorage.length,
   } ,
   reducers: {
       updateLength: (state) => {
           state.sessionLength = sessionStorage.length;
       },
   }
});

export const { updateAccountType, updateLength } = toolbarSlice.actions;
export default toolbarSlice.reducer;
