function sendSectionForm(section) {
    let input = document.createElement('input');
    input.type = 'hidden';
    input.name = 'section';
    input.value = section;

    sectionForm.append(input);
    sectionForm.submit();

}