function sendSectionForm(section) {
    // let input = document.createElement('input');
    // input.type = 'hidden';
    // input.name = 'section';
    // input.value = section;
    // sectionForm.append(input);

    //это по новому
    sectionForm[0].value = section;
    sectionForm.submit();

}

function sendViewCourseForm(id) {
    viewCourseForm[0].value = id;
    viewCourseForm.submit();
}